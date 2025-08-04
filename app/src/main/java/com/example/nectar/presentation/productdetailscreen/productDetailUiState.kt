package com.example.nectar.presentation.productdetailscreen

import com.example.nectar.data.mockdata.mockitem
import com.example.nectar.domain.model.Product

data class productDetailUiState(
    val product: Product = mockitem ,
    val currentCart: Int = 0 ,
    val favaourite: Boolean = false ,
)
