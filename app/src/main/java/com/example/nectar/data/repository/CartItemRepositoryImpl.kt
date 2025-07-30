package com.example.nectar.data.repository

import com.example.nectar.data.dao.CartDao
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow

class CartItemRepositoryImpl(
    private val cartDao: CartDao
) : CartItemRepository {

    override fun getAllCartItems(): Flow<List<CartItem>> {
        return cartDao.getAllCartItems()
    }

    override suspend fun insertOrUpdate(cartItem: CartItem) {
        cartDao.insertOrUpdate(cartItem)
    }

    override suspend fun deleteCartItem(cartItem: CartItem) {
        cartDao.deleteCartItem(cartItem)
    }

    override suspend fun getItemByProductId(productId: Int): CartItem? {
        return cartDao.getCartItemByProductId(productId)
    }

    override suspend fun addByChunk(productId: Int, price: Double, chunk: Int) {
        cartDao.addByChunks(productId, price, chunk)
    }

    override suspend fun removeByChunk(productId: Int, chunk: Int) {
        cartDao.removeByChunks(productId, chunk)
    }

    override suspend fun addToCart(product: Product) {
        addByChunk(productId = product.id, price = product.price, chunk = 1)
    }
}
