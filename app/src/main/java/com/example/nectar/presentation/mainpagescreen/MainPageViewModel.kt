package com.example.nectar.presentation.mainpagescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.data.database.prepopulateData
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import com.example.nectar.presentation.mainpagescreen.UiMainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiMainState())
    val uiState: StateFlow<UiMainState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val products = productRepository.getAll().first()
            if (products.isEmpty()) {
                productRepository.insertAll(prepopulateData())
            }
        }
        loadCategories()
        loadExclusiveOrders()
        loadProductsByCategories()
    }

    private fun loadCategories() {
        _uiState.update {
            it.copy(categoriesList = Category.values().toList())
        }
    }

    private fun loadExclusiveOrders() {
        viewModelScope.launch {
            productRepository.getAll().collect { products ->
                _uiState.update {
                    it.copy(exclusiveOrdersList = products)
                }
            }
        }
    }

    private fun loadProductsByCategories() {
        viewModelScope.launch {
            val categoryFlows = Category.values().map { category ->
                productRepository.getProductsByCategory(category.displayName)
            }

            combine(categoryFlows) { productLists ->
                productLists.toList()
            }.collect { combinedProducts ->
                _uiState.update {
                    it.copy(productsList = combinedProducts)
                }
            }
        }
    }


    fun onSearchQueryChange(query: String) {
        _uiState.update {
            it.copy(searchQuery = query)
        }
    }
}
