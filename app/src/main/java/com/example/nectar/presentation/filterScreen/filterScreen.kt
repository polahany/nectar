package com.example.nectar.presentation.filterScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.core.uicomponents.MainButton
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.core.uicomponents.ProductFullVerticalList
import com.example.nectar.presentation.navigation.NavigationDestination
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen
import kotlinx.coroutines.delay


object FilterDestination : NavigationDestination {
    override val route = "filter"
    override val title = route
}

@Composable
fun FilterScreen(
    onBack: () -> Unit,
    onCardClick: (Product) -> Unit,
    viewModel: FilterViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    var showResults by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.toggleBodyVisibility()
    }

    // to make the animations start after each other

    LaunchedEffect(uiState.isBodyVisible) {
        if (!uiState.isBodyVisible) {
            delay(200)
            showResults = true
        } else {
            showResults = false
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
            .background(Color.White)
    ) {

        TopFilterRow(
            onBack = onBack
        )

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedVisibility(
            visible = uiState.isBodyVisible,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it }) ,
            modifier = Modifier.weight(1f)
        ) {
            FilterBody(
                uiState = uiState,
                onCategoryChecked = { category, isChecked ->
                    viewModel.onCategoryChecked(category, isChecked)
                },
                onButtonClicked = viewModel::applyFilter
            )
        }

        AnimatedVisibility(
            visible = showResults,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it }) ,
            modifier = Modifier.weight(1f)
        ) {
            ProductFullVerticalList(
                items = uiState.resuls ,
                onCardClick = onCardClick,
            )
        }

    }
}

@Composable
fun FilterBody(
    uiState: FilterUiState,
    onCategoryChecked: (Category, Boolean) -> Unit,
    onButtonClicked : () -> Unit ,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        color = Color(220,220,220),
        tonalElevation = 8.dp,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Text(
                text ="Categories",
                style = Typography.displaySmall,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = mainBlack,
            )

            Spacer(modifier = Modifier.height(32.dp))

            Category.entries.forEach { category ->
                FilterCheckbox(
                    text = category.displayName,
                    isChecked = uiState.selectedCategories.contains(category),
                    onCheckedChange = { onCategoryChecked(category, it) }
                )
                Spacer(Modifier.height(28.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            MainButton(
                text = "Apply Filter",
                onClick = onButtonClicked,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun TopFilterRow(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        IconButton(
            onClick = onBack
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "back from category",
                modifier = Modifier
                    .size(height = 36.dp, width = 20.dp)
            )
        }
        Text(
            "Filters",
            style = Typography.displaySmall,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = mainBlack,
            modifier = Modifier.padding(start = 100.dp)
        )
    }
}

@Composable
fun FilterCheckbox(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = if (isChecked) mainGreen else Color.Transparent
                )
                .border(
                    width = 1.5.dp,
                    color = if (isChecked) mainGreen else Color.Gray,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { onCheckedChange(!isChecked) },
            contentAlignment = Alignment.Center
        ) {
            if (isChecked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "checked",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text ,
            style = Typography.bodyMedium ,
            fontSize = 16.sp ,
            color = if(isChecked) mainGreen else mainBlack ,
        )
    }
}




@Preview(showBackground = true)
@Composable
fun CategoryFilterScreenPreviewOnly() {

    FilterScreen({} ,{})
}
