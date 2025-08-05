package com.example.nectar.presentation.productdetailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.core.uicomponents.MainButton
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Shapes
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen
import com.example.nectar.ui.theme.secondaryText
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.data.mockdata.mockitem
import com.example.nectar.presentation.cartscreen.CartUiState

@Composable
fun DetailsContent(
    state: productDetailUiState ,
    product: Product?,
    onMinusClick: () -> Unit,
    onAddClick: () -> Unit,
    onExpandDetails: () -> Unit,
    onExpandNutrition: () -> Unit,
    onExpandReview: () -> Unit,
    onReview: () -> Unit,
    onButtonClick: () -> Unit,
    onBack: () -> Unit,
    onFavouriteClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        product?.let {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(Modifier.height(8.dp))

                NameAndDetailsRow(
                    product = product ,
                    onFavouriteClick = onFavouriteClick ,
                    state = state ,
                )

                Spacer(Modifier.height(32.dp))

                CartButtonsAndPriceRow(
                    state = state ,
                    onMinusClick = onMinusClick,
                    onAddClick = onAddClick,
                    product = product
                )

                Spacer(Modifier.height(16.dp))

                ExpandableList(
                    title = "Product Details",
                    product = product,
                    type = "product description"
                )

                Spacer(Modifier.height(20.dp))

                ExpandableList(
                    title = "Nutritions",
                    product = product,
                    type = "nutritions"
                )

                Spacer(Modifier.height(20.dp))

                ExpandableList(
                    title = "Review",
                    product = product,
                    type = "review"
                )

                Spacer(Modifier.height(16.dp))

                MainButton(
                    text = "Add To Basket",
                    onClick = {
                        onButtonClick()
                        onBack()
                    }
                )
            }
        }
    }
}

@Composable
fun CartButtonsAndPriceRow(
    state: productDetailUiState,
    product: Product,
    onMinusClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically ,
    ){
        CartButtons(
            state = state ,
            onMinusClick = onMinusClick,
            onAddClick = onAddClick
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "$${product.price}" ,
            style = Typography.displayMedium ,
            color = mainBlack ,
        )
    }
}

@Composable
fun CartButtons(
    state: productDetailUiState ,
    onMinusClick: () -> Unit ,
    onAddClick: () -> Unit ,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(120.dp)
    ) {
        IconButton(
            onClick = onMinusClick
        ) {
            Icon(
                imageVector = Icons.Filled.Remove ,
                contentDescription = "minus cart" ,
                tint = secondaryText ,
                modifier = Modifier
                    .size(17.dp)
            )
        }

        Card(
            shape = Shapes.extraSmall,
            modifier = Modifier
                .size(width = 45.67.dp, height = 45.67.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE2E2E2),
                    shape = Shapes.extraSmall
                )
                .clip(Shapes.extraSmall)
                .shadow(
                    elevation = 0.dp,
                    shape = Shapes.extraSmall,
                    clip = false
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = state.currentCart.toString(),
                    style = Typography.titleMedium,
                    color = mainBlack,
                )
            }
        }
        IconButton(
            onClick = onAddClick
        ) {
            Icon(
                imageVector = Icons.Filled.Add ,
                contentDescription = "add cart" ,
                tint = mainGreen,
                modifier = Modifier
                    .size(width = 17.dp , height = 17.dp)
            )
        }
    }
}

@Composable
fun NameAndDetailsRow(
    product: Product ,
    state: productDetailUiState ,
    onFavouriteClick: (Int) -> Unit ,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically ,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = product.name ,
            style = Typography.displayMedium ,
            lineHeight = 18.sp ,
            letterSpacing = 0.1.sp ,
            color = mainBlack ,
        )

        Spacer(Modifier.weight(1f))

        IconButton(
            onClick = { onFavouriteClick(product.id) }
        ) {
            Icon(
                imageVector = if(state.favaourite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder ,
                contentDescription = "add to favpurite" ,
                tint = if(state.favaourite) mainGreen else secondaryText ,
            )
        }


    }
    Spacer(Modifier.height(12.dp))
    Text(
        text = product.detail ,
        style = Typography.bodyLarge ,
        lineHeight = 18.sp ,
        fontSize = 16.sp ,
        color = secondaryText ,
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsContentPreview() {
    NectarTheme {
        DetailsContent(
            product = mockitem,
            onMinusClick = {},
            onAddClick = {},
            onExpandDetails = {},
            onExpandNutrition = {},
            onExpandReview = {},
            onReview = {},
            onButtonClick = {} ,
            state = productDetailUiState() ,
            onBack = {} ,
            onFavouriteClick = {}
        )
    }
}