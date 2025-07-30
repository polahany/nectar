package com.example.nectar.presentation.cartscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.CartItemRepository
import com.example.nectar.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartItemRepository: CartItemRepository ,
    private val productRepository: ProductRepository
) : ViewModel() {

    val _uiState = MutableStateFlow(CartUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            cartItemRepository.getAllCartItems().collect { cartItems ->
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
                    cartItemRepository.insertOrUpdate(updated)
                } else {
                    cartItemRepository.deleteCartItem(item)
                }
            }
            updateUiState(_uiState.value.cartItems)
        }
    }


    fun incrementItemCount(item: CartItem) {
        _uiState.update { state ->
            val currentCount = state.cartCounts[item.id] ?: item.quantity
            val newCount = currentCount + 1
            state.copy(
                cartCounts = state.cartCounts.toMutableMap().apply {
                    this[item.id] = newCount
                }
            )
        }
    }

    fun decrementItemCount(item: CartItem) {
        _uiState.update { state ->
            val currentCount = state.cartCounts[item.id] ?: item.quantity
            val newCount = (currentCount - 1).coerceAtLeast(0)
            state.copy(
                cartCounts = state.cartCounts.toMutableMap().apply {
                    this[item.id] = newCount
                }
            )
        }
    }


    fun deleteCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartItemRepository.deleteCartItem(cartItem)
            updateUiState(_uiState.value.cartItems)
        }
    }

    private fun updateUiState(cartItems: List<CartItem>) {
        val cartCounts = cartItems.associate { it.productId to it.quantity }
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
                    val product = productRepository.getProductById(item.productId)
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