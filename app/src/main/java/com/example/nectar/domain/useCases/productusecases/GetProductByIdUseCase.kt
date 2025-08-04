package com.example.nectar.domain.useCases.productusecases

import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(productId: Int) = productRepository.getProductById(productId)
}