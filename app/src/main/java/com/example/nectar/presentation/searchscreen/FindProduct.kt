package com.example.nectar.presentation.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.core.uicomponents.SearchBar
import com.example.nectar.presentation.core.uicomponents.CategoryCard
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.categoryColorsBodyAndBoarder
import com.example.nectar.ui.theme.mainBlack


val categories = listOf(
    "Fresh Fruits & Vegetables" ,
    "Cooking Oil & Ghee" ,
    "Meat & Fish" ,
    "Bakery & Snacks" ,
    "Dairy & Eggs" ,
    "Beverages"
)

val categoryImages = listOf(
    R.drawable.freshvegi ,
    R.drawable.oil ,
    R.drawable.meat ,
    R.drawable.bakery ,
    R.drawable.dairy ,
    R.drawable.beverages ,
)

@Composable
fun FindProductScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Spacer(Modifier.height(32.dp))
        Text(
            text = "Find Product" ,
            style = Typography.displaySmall ,
            fontWeight = FontWeight.Bold ,
            fontSize = 20.sp ,
            color = mainBlack ,
        )
        Spacer(Modifier.height(28.dp))
        SearchBar(
            onValueChange = {} ,
        )
        Spacer(Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2) ,
            verticalArrangement = Arrangement.spacedBy(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp) ,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(categories.size){
                categoryNumber ->
                CategoryCard(
                    imageRes = categoryImages[categoryNumber] ,
                    title = categories[categoryNumber] ,
                    backgroundColor = categoryColorsBodyAndBoarder[categoryNumber].first,
                    borderColor = categoryColorsBodyAndBoarder[categoryNumber].second,
                    onClick = {}
                )
            }
        }
    }
}


@Preview
@Composable
fun FindProductScreenPreview(modifier: Modifier = Modifier) {
    FindProductScreen()
}