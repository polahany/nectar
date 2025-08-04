package com.example.nectar.domain.useCases.cartusecase

import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.repository.CartItemRepository
import javax.inject.Inject

class UpsertCartItemUseCase @Inject constructor(
    private val cartItemRepository: CartItemRepository
) {
    suspend operator fun invoke(cartItem: CartItem) = cartItemRepository.insertOrUpdate(cartItem)
}