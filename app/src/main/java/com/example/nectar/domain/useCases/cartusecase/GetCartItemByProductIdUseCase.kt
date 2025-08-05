package com.example.nectar.domain.useCases.cartusecase

import com.example.nectar.domain.repository.CartItemRepository
import javax.inject.Inject

class GetCartItemByProductIdUseCase @Inject constructor(
    private val cartItemRepository: CartItemRepository
) {
    suspend operator fun invoke(productId : Int) = cartItemRepository.getItemByProductId(productId)
}