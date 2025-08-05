package com.example.nectar.presentation.filterScreen

import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product

data class FilterUiState(
    val selectedCategories: List<Category> = emptyList(),
    val isBodyVisible: Boolean = false ,
    val resuls: List<Product> = emptyList()
)
