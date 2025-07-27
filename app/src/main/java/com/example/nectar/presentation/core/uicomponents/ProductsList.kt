package com.example.nectar.core.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen

@Composable
fun ProductsList(
    name: String ,
    type: String ,
    items: List<Product> ,
    onClick: () -> Unit ,
    modifier: Modifier = Modifier)
{
    Column (
        modifier = Modifier
            .padding(
                top = 30.dp ,
                bottom = 30.dp
            )
    ){
        ListTitleBar(
            name = name ,
            type = type ,
            onClick = {}
        )
        Spacer(Modifier.height(20.dp))
        ItemsRow(
            items = items
        )
    }
}


@Composable
fun ListTitleBar(
    name: String ,
    type: String ,
    onClick: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(370.dp)
            .padding(end = 8.dp)
    ) {
        Text(
            text = name ,
            style = Typography.displayMedium ,
            color = mainBlack ,
        )
        Text(
            text = "See all" ,
            style = Typography.displayMedium ,
            color = mainGreen,
            fontSize = 16.sp ,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

@Composable
fun ItemsRow(
    items : List<Product>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(items){
            item ->
            ProductCard(
                product = item ,
                onCardClick = {} ,
                onAddClick = {} ,
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListPreview(modifier: Modifier = Modifier) {
    ProductsList(
        name = "Exclusive Offers",
        type = "exclusive",
        onClick = {},
        items = listOf(
            Product(
                name = "Natural Red Apple",
                detail = "1kg, Price",
                image_url = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
                price = 4.99,
                description = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healthful and varied diet.",
                category = "Fresh Fruits & Vegetable",
                nutritions = "100g",
                review = 5
            ),
            Product(
                name = "Sunflower Oil",
                detail = "1L, Price",
                image_url = "https://purepng.com/public/uploads/large/purepng.com-sunflower-oilsunflower-oilcooking-oilfrying-oilnon-volatile-oil-1411529833165ctzjx.png",
                price = 5.49,
                description = "Sunflower oil is light, healthy, and ideal for cooking and frying.",
                category = "Cooking Oil & Ghee",
                nutritions = "100ml",
                review = 4
            ),
            Product(
                name = "Salmon Fillet",
                detail = "300g, Price",
                image_url = "https://cdn.pixabay.com/photo/2021/05/25/11/43/fish-6282216_1280.jpg",
                price = 9.99,
                description = "Salmon is rich in omega-3 fatty acids and excellent for heart and brain health.",
                category = "Meat & Fish",
                nutritions = "100g",
                review = 5
            )
        )
    )
}
