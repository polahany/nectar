package com.example.nectar.data.dao

import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

import androidx.room.*
import com.example.nectar.domain.model.CartItem

@Dao
interface CartDao {

    @Query("SELECT * FROM cart_items")
    fun getAllCartItems(): Flow<List<CartItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(cartItem: CartItem)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem)

    @Query("SELECT * FROM cart_items WHERE productId = :productId LIMIT 1")
    suspend fun getCartItemByProductId(productId: Int): CartItem?

    @Transaction
    suspend fun addByChunks(productId: Int, price: Double, chunk: Int) {
        val existing = getCartItemByProductId(productId)
        if (existing != null) {
            val newQuantity = existing.quantity + chunk
            val newTotal = newQuantity * price
            val updated = existing.copy(
                quantity = newQuantity,
                totalPrice = newTotal
            )
            insertOrUpdate(updated)
        } else {
            val total = chunk * price
            val newItem = CartItem(
                productId = productId,
                quantity = chunk,
                price = price,
                totalPrice = total
            )
            insertOrUpdate(newItem)
        }
    }

    @Transaction
    suspend fun removeByChunks(productId: Int, chunk: Int) {
        val existing = getCartItemByProductId(productId)
        existing?.let {
            val newQuantity = (it.quantity - chunk).coerceAtLeast(0)
            if (newQuantity == 0) {
                deleteCartItem(it)
            } else {
                val newTotal = newQuantity * it.price
                val updated = it.copy(
                    quantity = newQuantity,
                    totalPrice = newTotal
                )
                insertOrUpdate(updated)
            }
        }
    }
}

