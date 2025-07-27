package com.example.nectar.core.uicomponents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.secondaryText


@Composable
fun ProductCard(
    product: Product,
    onCardClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(width = 173.32.dp, height = 248.51.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE2E2E2),
                shape = RoundedCornerShape(18.dp)
            )
            .clip(RoundedCornerShape(18.dp))
            .clickable { onCardClick() }
            .shadow(
                elevation = 0.dp,
                shape = RoundedCornerShape(18.dp),
                clip = false
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(16.dp))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image_url)
                    .crossfade(true)
                    .build(),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(104.dp, 62.dp)
            )

            Spacer(Modifier.height(32.dp))
            Text(
                text = product.name,
                style = Typography.titleSmall,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.1.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = product.detail,
                style = Typography.bodyLarge,
                fontSize = 14.sp,
                letterSpacing = 0.sp,
                color = secondaryText
            )
            Spacer(Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$${product.price}",
                    style = Typography.titleMedium,
                )
                Spacer(Modifier.weight(1f))
                AddButton(
                    onAddClick = onAddClick,
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductCardPreview(modifier: Modifier = Modifier) {
    val sampleProduct = Product(
        id = 1,
        name = "Natural Red Apple",
        detail = "1kg, Price",
        image_url = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
        price = 4.99,
        description = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart.",
        category = "Fresh Fruits & Vegetable",
        nutritions = "100g",
        review = 5
    )

    ProductCard(
        product = sampleProduct,
        onCardClick = {},
        onAddClick = {},
        modifier = modifier
    )
}
