package com.example.nectar.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val detail: String,
    val image_url: String,
    val price: Double,
    val description: String,
    val category: String,
    val nutritions: String,
    val review: Int ,
    // added to the entity
    val favourite: Boolean = false,
)

