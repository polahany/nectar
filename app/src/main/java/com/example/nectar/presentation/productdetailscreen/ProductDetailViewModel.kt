package com.example.nectar.presentation.productdetailscreen

import androidx.lifecycle.SavedStateHandle
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
class ProductDetailViewModel @Inject constructor(
    private val cartItemRepository: CartItemRepository ,
    private val productRepository: ProductRepository ,
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
                val product = productRepository.getProductById(productId)
                val cartItem = cartItemRepository.getItemByProductId(productId)

                _uiState.update {
                    it.copy(
                        product = product,
                        currentCart = cartItem?.quantity ?: 0
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
                cartItemRepository.getItemByProductId(product.id)?.let {
                    cartItemRepository.deleteCartItem(it)
                }
            } else {
                val total = quantity * product.price
                val cartItem = CartItem(
                    productId = product.id,
                    quantity = quantity,
                    price = product.price,
                    totalPrice = total
                )
                cartItemRepository.insertOrUpdate(cartItem)
            }
        }
    }

    fun setProduct(productId: Int) {
        viewModelScope.launch {
            try {
                val product = productRepository.getProductById(productId)
                _uiState.update {
                    it.copy(
                        product = product,
                    )
                }
            } catch (e: Exception) {
            }
        }
    }

}