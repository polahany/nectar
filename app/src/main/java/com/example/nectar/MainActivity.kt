package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.nectar.data.database.AppDatabase
import com.example.nectar.data.database.prepopulateData
import com.example.nectar.data.mockdata.mockitem
import com.example.nectar.presentation.SplashScreen.NectarSplashScreen
import com.example.nectar.presentation.productdetailscreen.ProductDetailScreen
import com.example.nectar.ui.theme.NectarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val db = AppDatabase.getDatabase(this)
//        lifecycleScope.launch {
//            db.productDao().getAll().first() // this line opens the DB and loads table/data
//        }


//        //  Initialize the database
//        val db = AppDatabase.getDatabase(this)
//        val productDao = db.productDao()
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            val isEmpty = productDao.getAll().first().isEmpty()
//            if (isEmpty) {
//                productDao.insertAll(prepopulateData())
//            }
//        }

        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            NectarTheme {
                NectarApp()
            }
        }
    }
}
