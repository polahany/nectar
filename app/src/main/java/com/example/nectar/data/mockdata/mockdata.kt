package com.example.nectar.data.mockdata

import com.example.nectar.domain.model.Product
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

val exclusiveOffers = listOf(
    Product(
        id= 1 ,
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
        id= 2 ,
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
        id= 3 ,
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
        id= 4 ,
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
        id= 5 ,
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
        id= 6 ,
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
        id= 7 ,
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
        id= 8 ,
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
        id= 9 ,
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
        id= 10 ,
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

public val mockitem = exclusiveOffers[0]

public val mocklists = listOf<Pair<String , List<Product>>>(
    "Exclusive Offers" to exclusiveOffers,
    "Best Selling" to bestSelling
)