package com.example.nectar.presentation.cartscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.CartItemRepository
import com.example.nectar.domain.repository.ProductRepository
import com.example.nectar.domain.useCases.cartusecase.DeleteCartItemUseCase
import com.example.nectar.domain.useCases.cartusecase.GetAllCartItemsUseCase
import com.example.nectar.domain.useCases.cartusecase.UpsertCartItemUseCase
import com.example.nectar.domain.useCases.productusecases.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllCartItemsUseCase: GetAllCartItemsUseCase ,
    private val deleteCartItemUseCase: DeleteCartItemUseCase ,
    private val upsertCartItemUseCase: UpsertCartItemUseCase ,
    private val getProductByIdUseCase: GetProductByIdUseCase ,
) : ViewModel() {

    val _uiState = MutableStateFlow(CartUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllCartItemsUseCase().collect { cartItems ->
                _uiState.update { it.copy(cartItems = cartItems) }
                loadCartProducts()
            }
        }
    }


    fun onButtonClick() {
        viewModelScope.launch {
            val cartItems = _uiState.value.cartItems
            val newCounts = _uiState.value.cartCounts

            cartItems.forEach { item ->
                val newCount = newCounts[item.id]
                if (newCount != null && newCount > 0) {
                    val updated = item.copy(
                        quantity = newCount,
                        totalPrice = item.price * newCount
                    )
                    upsertCartItemUseCase(updated)
                } else {
                    deleteCartItemUseCase(item)
                }
            }
            updateUiState(_uiState.value.cartItems)
        }
    }


    fun incrementItemCount(item: CartItem) {
        _uiState.update { state ->
            val currentCount = state.cartCounts[item.id] ?: item.quantity
            val newCount = currentCount + 1

            val updatedCartCounts = state.cartCounts.toMutableMap().apply {
                this[item.id] = newCount
            }

            val updatedTotal = state.cartItems.sumOf {
                val count = updatedCartCounts[it.id] ?: it.quantity
                it.price * count
            }

            state.copy(
                cartCounts = updatedCartCounts,
                totalPrice = updatedTotal
            )
        }
    }


    fun decrementItemCount(item: CartItem) {
        _uiState.update { state ->
            val currentCount = state.cartCounts[item.id] ?: item.quantity
            val newCount = (currentCount - 1).coerceAtLeast(0)

            val updatedCartCounts = state.cartCounts.toMutableMap().apply {
                this[item.id] = newCount
            }

            val updatedTotal = state.cartItems.sumOf {
                val count = updatedCartCounts[it.id] ?: it.quantity
                it.price * count
            }

            state.copy(
                cartCounts = updatedCartCounts,
                totalPrice = updatedTotal
            )
        }
    }



    fun deleteCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            deleteCartItemUseCase(cartItem)
            updateUiState(_uiState.value.cartItems)
        }
    }

    private fun updateUiState(cartItems: List<CartItem>) {
        val cartCounts = cartItems.associate { it.id to it.quantity }
        val total = cartItems.sumOf { it.totalPrice }

        _uiState.value = _uiState.value.copy(
            cartItems = cartItems,
            cartCounts = cartCounts,
            totalPrice = total
        )
    }



    fun loadCartProducts() {
        viewModelScope.launch {
            val productMap = mutableMapOf<Int, Product>()
            val countsMap = mutableMapOf<Int, Int>()
            for (item in _uiState.value.cartItems) {
                try {
                    val product = getProductByIdUseCase(item.productId)
                    productMap[item.productId] = product
                    countsMap[item.id] = item.quantity
                } catch (e: Exception) {
                }
            }
            _uiState.update { it.copy(
                cartProducts = productMap ,
                cartCounts = countsMap
                ) }
            updateUiState(_uiState.value.cartItems)
        }
    }
}