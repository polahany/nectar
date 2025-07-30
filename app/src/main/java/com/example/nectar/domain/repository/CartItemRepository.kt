package com.example.nectar.domain.repository


import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartItemRepository {

    fun getAllCartItems(): Flow<List<CartItem>>

    suspend fun insertOrUpdate(cartItem: CartItem)

    suspend fun deleteCartItem(cartItem: CartItem)

    suspend fun getItemByProductId(productId: Int): CartItem?

    suspend fun addByChunk(productId: Int, price: Double, chunk: Int)

    suspend fun removeByChunk(productId: Int, chunk: Int)

    suspend fun addToCart(product: Product)


}
