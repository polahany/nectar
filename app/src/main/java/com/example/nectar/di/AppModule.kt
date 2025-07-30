package com.example.nectar.di

import android.app.Application
import androidx.room.Room
import com.example.nectar.data.dao.CartDao
import com.example.nectar.data.dao.ProductDao
import com.example.nectar.data.database.AppDatabase
import com.example.nectar.data.repository.CartItemRepositoryImpl
import com.example.nectar.data.repository.ProductRepositoryImpl
import com.example.nectar.domain.repository.CartItemRepository
import com.example.nectar.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideProductDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "nectar_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase) = db.productDao()

    @Provides
    @Singleton
    fun provideProductRepository(productDao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(productDao)
    }

    @Provides
    @Singleton
    fun providesCartDao(db: AppDatabase) = db.cartDao()

    @Provides
    @Singleton
    fun providesCartRepository(cartDao: CartDao): CartItemRepository {
        return CartItemRepositoryImpl(cartDao)
    }

}