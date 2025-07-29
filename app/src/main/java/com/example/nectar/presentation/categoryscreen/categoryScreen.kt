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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.data.mockdata.mocklists
import com.example.nectar.presentation.core.uicomponents.ProductFullVerticalList
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack

@Composable
fun CategoryScreen(
    category: String ,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Spacer(Modifier.height(32.dp))
        TopCategoryScreenBar(
            category = category ,
            onBack = {} ,
            onFilter = {}
        )
        Spacer(Modifier.height(20.dp))

        ProductFullVerticalList(
            items = mocklists[0].second ,
            onAddClick = {} ,
            onCardClick = {} ,
        )
    }
}

@Composable
fun TopCategoryScreenBar(
    category: String,
    onBack: () -> Unit ,
    onFilter: () -> Unit ,
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
                imageVector = Icons.Default.KeyboardArrowLeft ,
                contentDescription = "back from category" ,
                modifier = Modifier
                    .size(height = 36.dp , width = 20.dp)
            )
        }
        Text(
            text = category ,
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
        "Vegetable"
    )
}