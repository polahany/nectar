package com.example.nectar.presentation.productdetailscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.searchBar
import com.example.nectar.ui.theme.secondaryText
import com.example.nectar.ui.theme.stars


@Composable
fun ExpandableList(
    title: String = "Product Detail",
    product: Product ,
    type: String ,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val iconRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = "iconRotation"
    )

    Column(
        modifier = Modifier
            .width(360.dp)
            .background(Color.White)
            .padding(12.dp)
    ) {
        Divider(color = Color.LightGray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )
            Spacer(Modifier.weight(1f))
            if(type == "nutritions"){
                NutritionDetail(product = product)
            }
            if (type == "review"){
                ReviewStars(
                    review = product.review
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Expand/Collapse",
                modifier = Modifier
                    .rotate(iconRotation)
                    .size(24.dp)
            )
        }
        if(type == "product description"){
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun NutritionDetail(
    product: Product,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(width = 34.dp, height = 18.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(searchBar),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = product.nutritions,
            style = Typography.displaySmall,
            fontSize = 9.sp,
            color = secondaryText,
        )
    }
}

@Composable
fun ReviewStars(
    review: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp) ,
        modifier = Modifier
            .width(92.dp)
    ) {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star ${index + 1}",
                tint = if (index < review) stars else secondaryText,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}



