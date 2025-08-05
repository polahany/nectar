package com.example.nectar.presentation.categoryscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.core.uicomponents.ProductFullVerticalList
import com.example.nectar.presentation.navigation.NavigationDestination
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack



object CategoryDestination : NavigationDestination{
    override val route = "category_items"
    override val title = route

    const val categoryArg = "category"
    val routeWithArgs = "$route/{$categoryArg}"
}
@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel<CategoryViewModel>(),
    category: String,
    onBack: () -> Unit,
    onCardClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiCategoryState by viewModel.uiState.collectAsState()

    viewModel.onCategoryChange(category)

    viewModel.loadPrducts()

    val displayName = uiCategoryState.category.displayName

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Spacer(Modifier.height(32.dp))
        TopCategoryScreenBar(
            displayName = displayName ,
            onBack = onBack ,
            onFilter = {}
        )
        Spacer(Modifier.height(20.dp))

        ProductFullVerticalList(
            items = uiCategoryState.products  ,
            onCardClick = onCardClick ,
        )
    }
}

@Composable
fun TopCategoryScreenBar(
    displayName: String,
    onBack: () -> Unit,
    onFilter: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ){
        IconButton(
            onClick = onBack
        ) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowLeft ,
                contentDescription = "back from category" ,
                modifier = Modifier
                    .size(height = 36.dp , width = 20.dp)
            )
        }
        Text(
            text = displayName ,
            style = Typography.displaySmall ,
            fontWeight = FontWeight.Bold ,
            fontSize = 20.sp ,
            color = mainBlack ,
        )

        IconButton(
            onClick = onFilter
        ) {
            Icon(
                imageVector = Icons.Default.Tune ,
                contentDescription = "back from details" ,
                modifier = Modifier
                    .size(height = 36.dp , width = 20.dp)
            )
        }
    }
}


@Preview
@Composable
fun CategoryScreenPreview(modifier: Modifier = Modifier) {
    CategoryScreen(
        category = "Vegetable" ,
        onBack = {} ,
        onCardClick = {}
    )
}