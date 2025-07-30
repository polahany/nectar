package com.example.nectar.domain.repository

import com.example.nectar.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertAll(products: List<Product>)

    fun getAll(): Flow<List<Product>>

    suspend fun getProductById(productId: Int): Product

    fun searchProductsByName(query: String): Flow<List<Product>>

    fun getProductsByCategory(category: String): Flow<List<Product>>
}