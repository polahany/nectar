package com.example.nectar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.nectar.data.dao.CartDao
import com.example.nectar.data.dao.ProductDao
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [CartItem::class, Product::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun cartDao(): CartDao

}


fun prepopulateData(): List<Product> = listOf(
    Product(name = "Natural Red Apple", detail = "1kg, Price", image_url = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg", price = 4.99, description = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healthful and varied diet.", category = "Fresh Fruits & Vegetable", nutritions = "100g", review = 5),
    Product(name = "Carrot", detail = "1kg, Price", image_url = "https://t3.ftcdn.net/jpg/02/99/43/48/360_F_299434842_UF1e0k44KUpkdtAEu0XbbPVnTHFuRwAm.jpg", price = 1.99, description = "Carrots are a great source of beta carotene, fiber, vitamin K1, and antioxidants.", category = "Fresh Fruits & Vegetable", nutritions = "100g", review = 4),
    Product(name = "Cucumber", detail = "1kg, Price", image_url = "https://img.freepik.com/premium-photo/cucumber-isolated-white-background_319514-5406.jpg", price = 1.49, description = "Cucumbers are low in calories and high in water and important vitamins and minerals.", category = "Fresh Fruits & Vegetable", nutritions = "100g", review = 3),
    Product(name = "Sunflower Oil", detail = "1L, Price", image_url = "https://purepng.com/public/uploads/large/purepng.com-sunflower-oilsunflower-oilcooking-oilfrying-oilnon-volatile-oil-1411529833165ctzjx.png", price = 5.49, description = "Sunflower oil is light, healthy, and ideal for cooking and frying.", category = "Cooking Oil & Ghee", nutritions = "100ml", review = 4),
    Product(name = "Pure Ghee", detail = "500g, Price", image_url = "https://rosepng.com/wp-content/uploads/2025/01/desi-ghee-1.png", price = 6.99, description = "Ghee is rich in fat-soluble vitamins and is used widely in traditional recipes.", category = "Cooking Oil & Ghee", nutritions = "100g", review = 5),
    Product(name = "Canola Oil", detail = "1L, Price", image_url = "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png", price = 4.79, description = "Canola oil is low in saturated fat and good for heart health.", category = "Cooking Oil & Ghee", nutritions = "100ml", review = 4),
    Product(name = "Fresh Chicken Breast", detail = "500g, Price", image_url = "https://cdn.pixabay.com/photo/2014/03/05/01/20/chicken-breast-279849_1280.jpg", price = 7.99, description = "Lean and protein-rich, ideal for healthy cooking.", category = "Meat & Fish", nutritions = "100g", review = 5),
    Product(name = "Salmon Fillet", detail = "300g, Price", image_url = "https://cdn.pixabay.com/photo/2021/05/25/11/43/fish-6282216_1280.jpg", price = 9.99, description = "Salmon is rich in omega-3 fatty acids and excellent for heart and brain health.", category = "Meat & Fish", nutritions = "100g", review = 5),
    Product(name = "Beef Steak", detail = "1kg, Price", image_url = "https://cdn.pixabay.com/photo/2018/02/08/15/02/meat-3139641_1280.jpg", price = 12.49, description = "High-protein and iron-rich red meat.", category = "Meat & Fish", nutritions = "100g", review = 4),
    Product(name = "Whole Wheat Bread", detail = "400g, Price", image_url = "https://media.istockphoto.com/id/185253149/photo/loafs-of-bread-on-white-background.jpg", price = 2.19, description = "Made with whole grains, good source of fiber.", category = "Bakery & Snacks", nutritions = "100g", review = 4),
    Product(name = "Butter Croissant", detail = "1pc, Price", image_url = "https://cdn.pixabay.com/photo/2012/02/29/12/17/bread-18987_1280.jpg", price = 1.49, description = "Flaky and buttery pastry, perfect for breakfast.", category = "Bakery & Snacks", nutritions = "100g", review = 5),
    Product(name = "Potato Chips", detail = "150g, Price", image_url = "https://cdn.pixabay.com/photo/2022/12/05/17/51/potato-chips-7637285_1280.jpg", price = 1.99, description = "Crispy, salted, and addictive snack.", category = "Bakery & Snacks", nutritions = "100g", review = 4),
    Product(name = "Fresh Milk", detail = "1L, Price", image_url = "https://img.freepik.com/premium-photo/glass-bottle-fresh-milk-isolated-white-background_252965-47.jpg", price = 2.29, description = "Rich in calcium and vitamin D for bone health.", category = "Dairy & Eggs", nutritions = "100ml", review = 5),
    Product(name = "Organic Eggs", detail = "12pcs, Price", image_url = "https://img.freepik.com/free-photo/three-fresh-organic-raw-eggs-isolated-white-surface_114579-43677.jpg", price = 3.49, description = "High in protein and healthy fats.", category = "Dairy & Eggs", nutritions = "100g", review = 5),
    Product(name = "Cheddar Cheese", detail = "250g, Price", image_url = "https://img.freepik.com/premium-photo/cheddar-cheese-isolated-white-background_407474-20664.jpg", price = 4.59, description = "Bold, tangy flavor great for sandwiches and cooking.", category = "Dairy & Eggs", nutritions = "100g", review = 4),
    Product(name = "Orange Juice", detail = "1L, Price", image_url = "https://img.freepik.com/premium-photo/orange-juice-white-background_269353-1137.jpg", price = 3.79, description = "Freshly squeezed and full of vitamin C.", category = "Beverages", nutritions = "100ml", review = 5),
    Product(name = "Green Tea", detail = "25 bags, Price", image_url = "https://img.freepik.com/premium-photo/cup-green-tea-with-leaves-white-background_787273-2374.jpg", price = 2.49, description = "Boosts metabolism and rich in antioxidants.", category = "Beverages", nutritions = "100g", review = 4),
    Product(name = "Cola Drink", detail = "500ml, Price", image_url = "https://img.freepik.com/premium-photo/drink-cola-with-ice-glass-white-background_55716-123.jpg", price = 1.19, description = "Classic carbonated soft drink.", category = "Beverages", nutritions = "100ml", review = 4)
)
