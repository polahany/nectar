package com.example.nectar.presentation.cartscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.nectar.core.uicomponents.MainButton
import com.example.nectar.presentation.navigation.NavigationDestination
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack


object CartDestination : NavigationDestination {
    override val route = "cart"
    override val title = route
}

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel<CartViewModel>(),
    navigateToOrderCheckout: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Spacer(Modifier.height(32.dp))
        Text(
            text = "My Cart" ,
            style = Typography.displaySmall ,
            fontWeight = FontWeight.Bold ,
            fontSize = 20.sp ,
            color = mainBlack ,
        )
        Spacer(Modifier.height(28.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ){
            items(uiState.cartItems){
                item ->
                val product = uiState.cartProducts[item.productId]
                if(product != null){
                    CartCard(
                        item = item ,
                        uiState = uiState ,
                        product = product,
                        onIncrement = { viewModel.incrementItemCount(item) } ,
                        onDecrement = { viewModel.decrementItemCount(item) } ,
                        onDelete = { viewModel.deleteCartItem(item) }
                    )
                }
            }
        }
        MainButton(
            onClick = {
                viewModel.onButtonClick()
                navigateToOrderCheckout()
                      } ,
            text = "Go to Checkout" ,
            isTotalPriceVisible = true ,
            totalPrice = uiState.totalPrice
        )
    }
}

@Preview
@Composable
fun CartScreenPreview(modifier: Modifier = Modifier) {
    CartScreen(navigateToOrderCheckout = {})
}