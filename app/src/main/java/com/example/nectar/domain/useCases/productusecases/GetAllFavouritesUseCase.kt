package com.example.nectar.domain.useCases.productusecases

import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllFavouritesUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke() = productRepository.getFavourites()
}