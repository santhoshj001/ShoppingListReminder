package com.teamb.shoppinglist.domain.repository

import com.teamb.shoppinglist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {

    suspend fun getShoppingItems(): List<ShoppingItem>

    suspend fun delete(item: ShoppingItem)

    suspend fun insert(item: ShoppingItem)

}