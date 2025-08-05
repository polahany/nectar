package com.example.nectar.presentation.explorescreen

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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.core.uicomponents.SearchBar
import com.example.nectar.domain.model.Category
import com.example.nectar.presentation.core.uicomponents.CategoryCard
import com.example.nectar.presentation.navigation.NavigationDestination
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack


object ExploreDestination : NavigationDestination{
    override val route = "explore"
    override val title = route
}


@Composable
fun ExploreProductScreen(
    onSearchClick: () -> Unit,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
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
            onClick = onSearchClick ,
            query = "" ,
            onSearchQueryChange = { } ,
        )
        Spacer(Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2) ,
            verticalArrangement = Arrangement.spacedBy(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp) ,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(Category.values()) { category ->
                CategoryCard(
                    category = category,
                    onClick = onCategoryClick
                )
            }
        }
    }
}


@Preview
@Composable
fun FindProductScreenPreview(modifier: Modifier = Modifier) {
    ExploreProductScreen({} , {})
}