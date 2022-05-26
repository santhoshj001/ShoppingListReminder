package com.teamb.shoppinglist.domain.repository

import com.teamb.shoppinglist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {

    fun getShoppingItems():Flow<List<ShoppingItem>>

    suspend fun delete(item: ShoppingItem)

    suspend fun insert(item: ShoppingItem)

}