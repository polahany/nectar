package com.example.nectar.presentation.cartscreen

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.presentation.productdetailscreen.NameAndDetailsRow
import com.example.nectar.ui.theme.DividerColor
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.secondaryText

@Composable
fun CartCard(
    item: CartItem,
    uiState: CartUiState,
    product : Product,
    onDelete: (CartItem) -> Unit,
    onIncrement: (CartItem) -> Unit,
    onDecrement: (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Divider(
            thickness = 1.dp,
            color = DividerColor,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image_url)
                    .crossfade(true)
                    .build(),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(75.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
            ) {
                CartItemNameAndDetailsRow(
                    item = item ,
                    onDelete = onDelete ,
                    product = product
                )

                Spacer(Modifier.height(8.dp))

                CartItemsButtonsAndPriceRow(
                    state = uiState ,
                    product = product ,
                    onIncrement = onIncrement ,
                    onDecrement = onDecrement ,
                    item = item ,
                )
            }

        }
    }
}

@Composable
fun CartItemNameAndDetailsRow(
    item: CartItem ,
    product: Product ,
    onDelete: (CartItem) -> Unit ,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp)
    ){
        Column {
            Text(
                text = product.name ,
                style = Typography.displayMedium ,
                fontSize = 16.sp,
                lineHeight = 18.sp ,
                letterSpacing = 0.1.sp ,
                fontWeight = FontWeight.Bold,
                color = mainBlack ,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = product.detail ,
                style = Typography.bodyLarge ,
                lineHeight = 18.sp ,
                fontSize = 14.sp ,
                color = secondaryText ,
            )
        }


        Spacer(Modifier.weight(1f))

        IconButton(
            onClick = { onDelete(item) }
        ) {
            Icon(
                imageVector = Icons.Rounded.Clear ,
                contentDescription = "delete" ,
                tint = secondaryText ,
            )
        }

    }
}


