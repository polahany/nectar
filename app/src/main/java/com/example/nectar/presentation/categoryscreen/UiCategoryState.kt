package com.example.nectar.presentation.categoryscreen

import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product

data class UiCategoryState (
    val category: Category = Category.FRESH_FRUITS_VEGETABLES ,
    val products: List<Product> = emptyList(),
)