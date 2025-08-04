package com.example.nectar.presentation.productdetailscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.useCases.cartusecase.DeleteCartItemUseCase
import com.example.nectar.domain.useCases.cartusecase.GetCartItemByProductIdUseCase
import com.example.nectar.domain.useCases.cartusecase.UpsertCartItemUseCase
import com.example.nectar.domain.useCases.productusecases.GetProductByIdUseCase
import com.example.nectar.domain.useCases.productusecases.ToggleFavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase ,
    private val getCartItemByProductIdUseCase: GetCartItemByProductIdUseCase ,
    private val deleteCartItemUseCase: DeleteCartItemUseCase ,
    private val upsertCartItemUseCase: UpsertCartItemUseCase ,
    private val toggleFavouriteUseCase: ToggleFavouriteUseCase ,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _uiState = MutableStateFlow(productDetailUiState())
    val uiState = _uiState.asStateFlow()

    private val productId: Int = checkNotNull(savedStateHandle["product"])

    init {
        initializeState(productId)
    }

    private fun initializeState(productId: Int) {
        viewModelScope.launch {
            try {
                val product = getProductByIdUseCase(productId)
                val cartItem = getCartItemByProductIdUseCase(productId)

                _uiState.update {
                    it.copy(
                        product = product,
                        currentCart = cartItem?.quantity ?: 0 ,
                        favaourite = product.favourite
                    )
                }
            } catch (e: Exception) {
                // Optionally handle error here
            }
        }
    }
    fun onPlusPressed() {
        _uiState.update { it.copy(currentCart = it.currentCart + 1) }
    }

    fun onMinusPressed() {
        _uiState.update { it.copy(currentCart = (it.currentCart - 1).coerceAtLeast(0)) }
    }

    fun onButtonPressed() {
        val product = uiState.value.product
        val quantity = uiState.value.currentCart

        viewModelScope.launch {
            if (quantity == 0) {
                getCartItemByProductIdUseCase(product.id)?.let {
                    deleteCartItemUseCase(it)
                }
            } else {
                val total = quantity * product.price
                val cartItem = CartItem(
                    productId = product.id,
                    quantity = quantity,
                    price = product.price,
                    totalPrice = total
                )
                upsertCartItemUseCase(cartItem)
            }
        }
    }

    fun setProduct(productId: Int) {
        viewModelScope.launch {
            try {
                val product = getProductByIdUseCase(productId)
                _uiState.update {
                    it.copy(
                        product = product,
                    )
                }
            } catch (e: Exception) {
            }
        }
    }

    fun onFavouriteClicked(productId: Int) {
        viewModelScope.launch {
            val newFavourite = toggleFavouriteUseCase(productId)
            _uiState.update { it.copy(favaourite = newFavourite) }
        }
    }
}