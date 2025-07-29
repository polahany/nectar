package com.example.nectar.presentation.productdetailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectar.data.mockdata.mockitem
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.myMainBackGround

@Composable
fun ProductDetailScreen(
    product: Product ,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(myMainBackGround)
    ) {
        DetailsCard(
            product = product ,
            onBack = {} ,
            onDownload = {}
        )
        DetailsContent(
            product = product ,
            onMinusClick = {} ,
            onAddClick = {} ,
            onExpandDetails = {} ,
            onExpandNutrition = {} ,
            onExpandReview = {} ,
            onReview = {} ,
            onButtonClick = {} ,
        )
    }
}



@Preview
@Composable
fun ProductDetailPreview(modifier: Modifier = Modifier) {
    ProductDetailScreen(
        product = mockitem ,
    )
}