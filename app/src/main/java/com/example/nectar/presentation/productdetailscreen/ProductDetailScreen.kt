package com.example.nectar.presentation.productdetailscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectar.data.database.AppDatabase
import com.example.nectar.data.mockdata.mockitem
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.navigation.NavigationDestination
import com.example.nectar.ui.theme.myMainBackGround


object ProductDetailDestination : NavigationDestination{
    override val route = "product_details"
    override val title = route

    const val productArg = "product"
    val routeWithArgs = "$route/{$productArg}"
}

@Composable
fun ProductDetailScreen(
    productId: Int ,
    onBack: () -> Unit ,
    modifier: Modifier = Modifier
) {

    Log.d("detail screen", productId.toString())

    val context = LocalContext.current
    val productDao = remember { AppDatabase.getDatabase(context).productDao() }

    var product by remember { mutableStateOf<Product?>(mockitem) }

    LaunchedEffect(productId) {
        product = productDao.getProductById(productId)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(myMainBackGround)
    ) {
        DetailsCard(
            product = product ,
            onBack = onBack ,
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
        productId = mockitem.id ,
        onBack = {}
    )
}