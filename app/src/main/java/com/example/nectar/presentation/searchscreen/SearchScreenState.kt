package com.example.nectar.presentation.searchscreen

import com.example.nectar.domain.model.Product

data class SearchScreenState(
    val searchQuery: String = "",
    val searchResults: List<Product> = emptyList(),
)
