package com.example.nectar.presentation.cartscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Shapes
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen
import com.example.nectar.ui.theme.secondaryText

@Composable
fun CartItemsButtonsAndPriceRow(
    state: CartUiState,
    product: Product,
    item: CartItem,
    onIncrement: (CartItem) -> Unit,
    onDecrement: (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(start = 32.dp)
            .fillMaxWidth()
    ) {
        CartItemButtons(
            state = state,
            item = item,
            onIncrement = onIncrement,
            onDecrement = onDecrement
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "$${product.price}",
            style = Typography.displayMedium,
            color = mainBlack,
            fontSize = 16.sp,
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
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.width(IntrinsicSize.Min)
    ) {
        CartIconBox(
            onClick = { onDecrement(item) },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Remove,
                    contentDescription = "minus cart",
                    tint = secondaryText,
                    modifier = Modifier.size(28.dp)
                )
            },
            modifier = Modifier.size(45.67.dp)
        )

        Card(
            shape = Shapes.extraSmall,
            modifier = Modifier
                .size(45.67.dp)
                .padding(horizontal = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = state.cartCounts[item.id].toString(),
                    style = Typography.titleMedium,
                    fontSize = 16.sp,
                    color = mainBlack,
                )
            }
        }

        CartIconBox(
            onClick = { onIncrement(item) },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "add cart",
                    tint = mainGreen,
                    modifier = Modifier.size(28.dp)
                )
            },
            modifier = Modifier.size(45.67.dp)
        )
    }
}

@Composable
fun CartIconBox(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(Shapes.extraSmall)
            .border(
                width = 1.dp,
                color = Color(0xFFE2E2E2),
                shape = Shapes.extraSmall
            )
            .shadow(
                elevation = 0.dp,
                shape = Shapes.extraSmall,
                clip = false
            )
            .clickable(onClick = onClick)
    ) {
        icon()
    }
}
