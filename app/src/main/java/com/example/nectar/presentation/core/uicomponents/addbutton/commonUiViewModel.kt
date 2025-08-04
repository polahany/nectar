package com.example.nectar.presentation.core.uicomponents.addbutton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.CartItemRepository
import com.example.nectar.domain.useCases.cartusecase.AddToCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class commonUiViewModel @Inject constructor(
    private val addToCartUseCase: AddToCartUseCase
) : ViewModel(){

    fun onAddToCartClicked(product: Product) {
        viewModelScope.launch {
            addToCartUseCase(product)
        }
    }
}