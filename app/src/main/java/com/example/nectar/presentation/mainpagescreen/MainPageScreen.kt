package com.example.nectar.presentation.mainpagescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.core.uicomponents.ProductsList
import com.example.nectar.core.uicomponents.SearchBar
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.core.uicomponents.CategoryList
import com.example.nectar.presentation.navigation.NavigationDestination


object MainDestination : NavigationDestination{
    override val route  = "mainscreen"
    override val title = route
}

@Composable
fun MainPage(
    onCardClick: (Product) -> Unit,
    onCategoryClick: (Category) -> Unit,
    onSearchClick: () -> Unit,
    viewModel: MainPageViewModel = hiltViewModel<MainPageViewModel>(),
    modifier: Modifier = Modifier
) {
    val mainState by viewModel.uiState.collectAsState()
    MainPageContent(
        uiMainState = mainState,
        onCardClick = onCardClick,
        onSearchClick = onSearchClick,
        onCategoryClick = onCategoryClick,
    )
}


@Composable
fun MainPageContent(
    uiMainState: UiMainState,
    onCardClick : (Product) -> Unit,
    onSearchClick : () -> Unit,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            LogoAndLocation()
            Spacer(Modifier.height(24.dp))
            SearchBar(
                onClick = onSearchClick ,
                query = "",
                onSearchQueryChange = { } ,
            )
            Spacer(Modifier.height(24.dp))
            Adverstisment()
        }
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(start = 24.dp)
        ) {
            item {
                ProductsList(
                    name = "Exclusive Offer" ,
                    type = "exclusive" ,
                    items = uiMainState.exclusiveOrdersList ,
                    onCardClick = onCardClick ,
                    onClick = {} ,
                )
            }

            item {
                CategoryList(
                    categories = uiMainState.categoriesList,
                    onSeeAllClick = {},
                    onCategoryClick = onCategoryClick ,
                )
            }

            item {
                if(uiMainState.favouriteList.isNotEmpty()){
                    ProductsList(
                        name = "Favourites" ,
                        type = "favourites" ,
                        items = uiMainState.favouriteList ,
                        onCardClick = onCardClick ,
                        onClick = {}
                    )
                }
            }

            items(uiMainState.productsList) { list ->
                if (list.isNotEmpty()) {
                    ProductsList(
                        name = list[0].category,
                        type = "products",
                        items = list,
                        onCardClick = onCardClick,
                        onClick = {}
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    MainPage({} ,{} ,{})
}

