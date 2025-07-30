package com.example.nectar.presentation.categoryscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(UiCategoryState())
    val uiState: StateFlow<UiCategoryState> = _uiState.asStateFlow()

    fun loadPrducts(){
        viewModelScope.launch {
            val products = productRepository.getProductsByCategory(_uiState.value.category.displayName)
                .collect {
                    products ->
                    _uiState.update {
                        it.copy(products = products)
                    }
                }
        }
    }

    fun onCategoryChange(category: String){
        _uiState.update {
            it.copy(category = Category.valueOf(category))
        }
    }
}
