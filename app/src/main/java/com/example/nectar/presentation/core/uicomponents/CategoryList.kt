package com.example.nectar.presentation.core.uicomponents

import com.example.nectar.core.uicomponents.ProductCard



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen

@Composable
fun CategoryList(
    title: String = "Category",
    categories: List<Category>,
    onSeeAllClick: () -> Unit,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = 30.dp, bottom = 30.dp)
    ) {
        // Title + See All
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = Typography.displayMedium,
                color = mainBlack
            )
            Text(
                text = "See all",
                style = Typography.displayMedium,
                color = mainGreen,
                fontSize = 16.sp,
                modifier = Modifier.clickable { onSeeAllClick() }
            )
        }

        Spacer(Modifier.height(20.dp))

        // Horizontal scroll of category cards
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                HorizontalCategoryCard(
                    category = category,
                    onClick = { onCategoryClick(category) }
                )
            }
        }
    }
}

