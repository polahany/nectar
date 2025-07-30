package com.example.nectar.presentation.cartscreen

import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product

data class CartUiState(
    val cartItems: List<CartItem> = emptyList(),
    val cartProducts: Map<Int, Product> = emptyMap() ,
    val cartCounts: Map<Int, Int> = emptyMap() ,
    val totalPrice: Double = 0.0
)
