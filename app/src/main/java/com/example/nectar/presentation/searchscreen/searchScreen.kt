package com.example.nectar.presentation.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.core.uicomponents.SearchBar
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.core.uicomponents.ProductFullVerticalList
import com.example.nectar.presentation.navigation.NavigationDestination


object SearchDestination : NavigationDestination {
    override val route = "search"
    override val title = route
}

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel<SearchViewModel>(),
    onCardClick: (Product) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp , vertical = 36.dp )
    ) {
       val state by viewModel.uiState.collectAsState()

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) ,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                SearchBar(
                    onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
                    query = state.searchQuery ,
                    onCancel = {
                        viewModel.clearSearchResults()
                        onCancel()
                    }
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Tune ,
                    contentDescription = "back from details" ,
                    modifier = Modifier
                        .size(height = 36.dp , width = 20.dp)
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        ProductFullVerticalList(
            items = state.searchResults ,
            onCardClick = onCardClick ,
        )
    }
}


@Preview
@Composable
fun SearchScreenPreview(modifier: Modifier = Modifier) {
    SearchScreen(
        onCardClick = {} ,
        onCancel = {}
    )
}
