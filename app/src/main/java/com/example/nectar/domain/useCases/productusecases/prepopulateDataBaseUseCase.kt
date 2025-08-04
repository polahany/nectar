package com.example.nectar.domain.useCases.productusecases

import com.example.nectar.data.repository.ProductRepositoryImpl
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class prepopulateDataBaseUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(products: List<Product>) = productRepository.insertAll(products)
}