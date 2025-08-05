package com.example.nectar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nectar.domain.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

    @Query("SELECT * FROM products")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE id = :productId")
    suspend fun getProductById(productId: Int): Product

    @Query("SELECT * FROM products WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%'")
    fun searchProductsByName(query: String): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE LOWER(category) = LOWER(:category)")
    fun getProductsByCategory(category: String): Flow<List<Product>>

    @Query("UPDATE products SET favourite = NOT favourite WHERE id = :productId")
    suspend fun toggleFavourite(productId: Int)

    @Query("SELECT favourite FROM products WHERE id = :productId")
    suspend fun getFavouriteStatus(productId: Int): Boolean

    @Query("SELECT * FROM products WHERE favourite = 1")
    fun getFavourites(): Flow<List<Product>>

}
