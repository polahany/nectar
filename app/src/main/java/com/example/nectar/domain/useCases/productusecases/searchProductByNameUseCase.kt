package com.example.nectar.domain.useCases.productusecases

import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class searchProductByNameUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke(query: String) = productRepository.searchProductsByName(query)
}