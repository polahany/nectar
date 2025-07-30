package com.example.nectar.presentation.core.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nectar.core.uicomponents.ProductCard
import com.example.nectar.domain.model.Product

@Composable
fun ProductFullVerticalList(
    items: List<Product>,
    onCardClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2) ,
        verticalArrangement = Arrangement.spacedBy(16.dp) ,
        horizontalArrangement = Arrangement.spacedBy(16.dp) ,
        modifier = Modifier
            .fillMaxWidth()
    ){
        items(items) {
            item ->
            ProductCard(
                product = item ,
                onAddClick = {} ,
                onCardClick = onCardClick
            )
        }
    }
}