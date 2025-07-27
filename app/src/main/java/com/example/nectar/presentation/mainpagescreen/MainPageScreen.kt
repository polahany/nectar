package com.example.nectar.presentation.mainpagescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.core.uicomponents.NavigationBar
import com.example.nectar.core.uicomponents.ProductsList
import com.example.nectar.core.uicomponents.SearchBar


import com.example.nectar.domain.model.Product

val exclusiveOffers = listOf(
    Product(
        name = "Natural Red Apple",
        detail = "1kg, Price",
        image_url = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
        price = 4.99,
        description = "Apples are nutritious and may support weight loss and heart health.",
        category = "Fresh Fruits & Vegetables",
        nutritions = "100g",
        review = 5
    ),
    Product(
        name = "Sunflower Oil",
        detail = "1L, Price",
        image_url = "https://purepng.com/public/uploads/large/purepng.com-sunflower-oilsunflower-oilcooking-oilfrying-oilnon-volatile-oil-1411529833165ctzjx.png",
        price = 5.49,
        description = "Light and healthy oil ideal for cooking and frying.",
        category = "Cooking Oil & Ghee",
        nutritions = "100ml",
        review = 4
    ),
    Product(
        name = "Whole Wheat Bread",
        detail = "400g, Price",
        image_url = "https://cdn.pixabay.com/photo/2015/09/16/20/20/bread-941869_1280.jpg",
        price = 3.29,
        description = "Fresh whole wheat bread baked daily.",
        category = "Bakery & Bread",
        nutritions = "100g",
        review = 4
    ),
    Product(
        name = "Almond Milk",
        detail = "1L, Price",
        image_url = "https://cdn.pixabay.com/photo/2017/05/12/08/29/almond-2306523_1280.jpg",
        price = 4.75,
        description = "Dairy-free milk alternative rich in vitamins.",
        category = "Dairy & Eggs",
        nutritions = "100ml",
        review = 5
    ),
    Product(
        name = "Fresh Strawberries",
        detail = "500g, Price",
        image_url = "https://cdn.pixabay.com/photo/2017/07/31/11/21/strawberries-2553099_1280.jpg",
        price = 6.25,
        description = "Juicy and sweet strawberries packed with antioxidants.",
        category = "Fresh Fruits & Vegetables",
        nutritions = "100g",
        review = 5
    )
)

val bestSelling = listOf(
    Product(
        name = "Salmon Fillet",
        detail = "300g, Price",
        image_url = "https://cdn.pixabay.com/photo/2021/05/25/11/43/fish-6282216_1280.jpg",
        price = 9.99,
        description = "Rich in omega-3 fatty acids, great for heart and brain health.",
        category = "Meat & Fish",
        nutritions = "100g",
        review = 5
    ),
    Product(
        name = "Organic Banana",
        detail = "1kg, Price",
        image_url = "https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg",
        price = 2.99,
        description = "High in potassium and perfect for a quick energy boost.",
        category = "Fresh Fruits & Vegetables",
        nutritions = "100g",
        review = 4
    ),
    Product(
        name = "Avocado",
        detail = "1pc, Price",
        image_url = "https://cdn.pixabay.com/photo/2017/07/16/10/43/avocado-2501342_1280.jpg",
        price = 1.89,
        description = "Creamy and nutrient-rich fruit perfect for toast or salad.",
        category = "Fresh Fruits & Vegetables",
        nutritions = "100g",
        review = 5
    ),
    Product(
        name = "Brown Eggs",
        detail = "12pcs, Price",
        image_url = "https://cdn.pixabay.com/photo/2016/03/05/19/02/eggs-1239249_1280.jpg",
        price = 3.99,
        description = "Farm-fresh eggs rich in protein.",
        category = "Dairy & Eggs",
        nutritions = "1 egg",
        review = 4
    ),
    Product(
        name = "Broccoli",
        detail = "1kg, Price",
        image_url = "https://cdn.pixabay.com/photo/2018/04/12/11/38/broccoli-3312974_1280.jpg",
        price = 3.25,
        description = "Fresh broccoli full of fiber and vitamin C.",
        category = "Fresh Fruits & Vegetables",
        nutritions = "100g",
        review = 4
    )
)

public val lists = listOf<Pair<String , List<Product>>>(
    "Exclusive Offers" to exclusiveOffers,
    "Best Selling" to bestSelling
)



@Composable
fun MainPage(modifier: Modifier = Modifier) {
    MainPageContent()
}

@Composable
fun MainPageContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            LogoAndLocation()
            Spacer(Modifier.height(24.dp))
            SearchBar(
                onValueChange = {}
            )
            Spacer(Modifier.height(24.dp))
            Adverstisment()
        }
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(start = 24.dp)
        ) {
            items(lists){
                    (title , items)->
                ProductsList(
                    name = title ,
                    type = title ,
                    items = items,
                    onClick = {}
                )
            }
        }
    }
}




@Preview
@Composable
fun MainPagePreview(modifier: Modifier = Modifier) {
    MainPage()
}