package com.example.nectar.presentation.mainpagescreen

import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product

data class UiMainState  (
    val exclusiveOrdersList: List<Product> = emptyList(),
    val categoriesList: List<Category> = emptyList(),
    val productsList: List<List<Product>> = emptyList(),
)
