package com.example.nectar.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.nectar.R

enum class Category(
    val displayName: String,
    @DrawableRes val imageRes: Int,
    val backgroundColor: Color,
    val borderColor: Color
) {
    FRESH_FRUITS_VEGETABLES("Fresh Fruits & Vegetable", R.drawable.freshvegi, Color(0xFFF1F8E9), Color(0xFFDCEDC8)),
    COOKING_OIL_GHEE("Cooking Oil & Ghee", R.drawable.oil, Color(0xFFFFF3E0), Color(0xFFFFE0B2)),
    MEAT_FISH("Meat & Fish", R.drawable.meat, Color(0xFFFFEBEE), Color(0xFFFFCDD2)),
    BAKERY_SNACKS("Bakery & Snacks", R.drawable.bakery, Color(0xFFFFFDE7), Color(0xFFFFF9C4)),
    DAIRY_EGGS("Dairy & Eggs", R.drawable.dairy, Color(0xFFE3F2FD), Color(0xFFBBDEFB)),
    BEVERAGES("Beverages", R.drawable.beverages, Color(0xFFE8F5E9), Color(0xFFC8E6C9))
}

