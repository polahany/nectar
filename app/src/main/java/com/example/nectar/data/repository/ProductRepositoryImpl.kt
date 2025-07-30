package com.example.nectar.data.repository

import com.example.nectar.data.dao.ProductDao
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl (
    private val productDao : ProductDao
) : ProductRepository {
    override suspend fun insertAll(products: List<Product>) {
        productDao.insertAll(products)
    }

    override fun getAll(): Flow<List<Product>> {
        return productDao.getAll()
    }

    override suspend fun getProductById(productId: Int): Product {
        return productDao.getProductById(productId)
    }

    override fun searchProductsByName(query: String): Flow<List<Product>> {
        return productDao.searchProductsByName(query)
    }

    override fun getProductsByCategory(category: String): Flow<List<Product>> {
        return productDao.getProductsByCategory(category)
    }
}