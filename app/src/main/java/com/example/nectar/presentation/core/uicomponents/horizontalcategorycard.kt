package com.example.nectar.presentation.core.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.domain.model.Category
import com.example.nectar.ui.theme.Shapes
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack

@Composable
fun HorizontalCategoryCard(
    category: Category ,
    onClick: (Category) -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 248.dp , height = 105.dp)
            .clip(Shapes.small)
            .background(category.backgroundColor)
            .border(width = 1.dp, color = category.borderColor, shape = Shapes.small)
            .clickable { onClick(category) },
        contentAlignment = Alignment.Center
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.displayName,
                modifier = Modifier
                    .size(72.dp)
                    .clickable { onClick(category) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = category.displayName,
                style = Typography.displaySmall ,
                fontWeight = FontWeight.Bold ,
                fontSize = 16.sp ,
                lineHeight = 22.sp ,
                letterSpacing = 0.1.sp ,
                maxLines = 2 ,
                color = mainBlack ,
                textAlign = TextAlign.Center
            )
        }
    }
}
