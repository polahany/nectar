package com.example.nectar.presentation.filterScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val productRepository: ProductRepository ,
) : ViewModel() {

    private val _uiState = MutableStateFlow(FilterUiState())
    val uiState: StateFlow<FilterUiState> = _uiState

    fun onCategoryChecked(category: Category, isChecked: Boolean) {
        val current = _uiState.value.selectedCategories
        val updated = if (isChecked) current + category else current - category
        _uiState.value = _uiState.value.copy(selectedCategories = updated)
    }

    fun toggleBodyVisibility() {
        _uiState.value = _uiState.value.copy(isBodyVisible = !_uiState.value.isBodyVisible)
    }

    fun applyFilter() {
        viewModelScope.launch {
            val selected = uiState.value.selectedCategories

            val products = selected
                .map { category ->
                    productRepository.getProductsByCategory(category.displayName).first()
                }
                .flatten()
                .distinctBy { it.id }

            Log.d("FilterViewModel", "Filtered Products (${products.size}):")
            products.forEach { product ->
                Log.d("FilterViewModel", product.toString())
            }

            _uiState.update {
                it.copy(
                    isBodyVisible = false,
                    resuls = products
                )
            }
        }
    }

}
