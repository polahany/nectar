package com.example.nectar.domain.useCases.cartusecase

import com.example.nectar.domain.repository.CartItemRepository
import javax.inject.Inject

class GetAllCartItemsUseCase @Inject constructor(
    private val cartItemRepository: CartItemRepository
) {
    operator fun invoke() = cartItemRepository.getAllCartItems()
}

