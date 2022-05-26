package com.teamb.shoppinglist.domain.repository

import com.teamb.shoppinglist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {

    fun getShoppingItems(): Flow<List<ShoppingItem>>

    fun getShoppingItemById(itemId: Int)  : Flow<ShoppingItem>

    suspend fun delete(itemId: Int)

    suspend fun insert(item: ShoppingItem)

}