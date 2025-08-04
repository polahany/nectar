package com.example.nectar.domain.useCases.cartusecase

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.CartItemRepository
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    private val cartItemRepository: CartItemRepository
) {
    suspend operator fun invoke(product: Product) = cartItemRepository.addToCart(product)
}