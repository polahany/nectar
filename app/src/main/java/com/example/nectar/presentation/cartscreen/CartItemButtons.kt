package com.example.nectar.presentation.cartscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
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
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Shapes
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen
import com.example.nectar.ui.theme.secondaryText

@Composable
fun CartItemsButtonsAndPriceRow(
    state:  CartUiState,
    product: Product,
    item: CartItem,
    onIncrement: (CartItem) -> Unit ,
    onDecrement: (CartItem) -> Unit ,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically ,
    ){
        CartItemButtons(
            state = state ,
            onIncrement = onIncrement,
            onDecrement = onDecrement ,
            item = item
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
fun CartItemButtons(
    state: CartUiState,
    item: CartItem,
    onIncrement: (CartItem) -> Unit,
    onDecrement: (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(120.dp)
    ) {
        IconButton(
            onClick = { onDecrement(item) }
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
                    text = state.cartCounts[item.id].toString(),
                    style = Typography.titleMedium,
                    color = mainBlack,
                )
            }
        }
        IconButton(
            onClick = { onIncrement(item) }
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
