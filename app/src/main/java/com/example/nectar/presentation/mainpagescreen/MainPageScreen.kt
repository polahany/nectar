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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.core.uicomponents.NavigationBar
import com.example.nectar.core.uicomponents.ProductsList
import com.example.nectar.core.uicomponents.SearchBar
import com.example.nectar.data.mockdata.mocklists
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.navigation.NavigationDestination


object MainDestination : NavigationDestination{
    override val route  = "mainscreen"
    override val title = route
}

@Composable
fun MainPage(
    onCardClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    MainPageContent(
        onCardClick = onCardClick,
        modifier = modifier
    )
}


@Composable
fun MainPageContent(
    onCardClick : (Product) -> Unit,
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
                onValueChange = {}
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
            items(mocklists){
                    (title , items)->
                ProductsList(
                    name = title ,
                    type = title ,
                    items = items,
                    onCardClick = onCardClick ,
                    onClick = {} ,
                )
            }
        }
    }
}




@Preview
@Composable
fun MainPagePreview(modifier: Modifier = Modifier) {
    MainPage({}  )
}