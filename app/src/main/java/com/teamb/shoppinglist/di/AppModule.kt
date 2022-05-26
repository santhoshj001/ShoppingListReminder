package com.teamb.shoppinglist.di

import android.app.Application
import androidx.room.Room
import com.teamb.shoppinglist.data.data_source.database.ShoppingDatabase
import com.teamb.shoppinglist.data.repository.ShoppingRepositoryImpl
import com.teamb.shoppinglist.domain.repository.ShoppingRepository
import com.teamb.shoppinglist.domain.usecase.*
import com.teamb.shoppinglist.domain.usecase.validation.ItemNameValidationUseCase
import com.teamb.shoppinglist.domain.usecase.validation.ItemQuantityValidationUseCase
import com.teamb.shoppinglist.domain.usecase.validation.ValidationUseCase
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
    fun providesDatabase(application: Application): ShoppingDatabase {
        return Room.databaseBuilder(
            application,
            ShoppingDatabase::class.java,
            ShoppingDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesShoppingRepository(shoppingDatabase: ShoppingDatabase): ShoppingRepository {
        return ShoppingRepositoryImpl(shoppingDatabase.shoppingDao)
    }

    @Provides
    @Singleton
    fun providesShoppingUseCase(repository: ShoppingRepository): ShoppingUseCase {
        return ShoppingUseCase(
            addShoppingItemUseCase = AddShoppingItemUseCase(repository = repository),
            deleteShoppingItemUseCase = DeleteShoppingItemUseCase(repository = repository),
            updateShoppingItemUseCase = UpdateShoppingItemUseCase(repository = repository),
            getShoppingItemsUseCase = GetShoppingItemsUseCase(repository = repository),
            getShoppingItemByIdUseCase = GetShoppingItemByIdUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideValidationUse(): ValidationUseCase {
        return ValidationUseCase(
            itemNameValidationUseCase = ItemNameValidationUseCase(),
            itemQuantityValidationUseCase = ItemQuantityValidationUseCase()
        )
    }
}