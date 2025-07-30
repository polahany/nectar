package com.example.nectar.presentation.core.uicomponents

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.CartItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class commonUiViewModel @Inject constructor(
    private val cartItemRepository: CartItemRepository
) : ViewModel(){

    fun onAddToCartClicked(product: Product) {
        viewModelScope.launch {
            cartItemRepository.addToCart(product)
        }
    }
}