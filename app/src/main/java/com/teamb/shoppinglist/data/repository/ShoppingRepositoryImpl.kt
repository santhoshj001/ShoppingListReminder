package com.teamb.shoppinglist.data.repository

import com.teamb.shoppinglist.data.data_source.dao.ShoppingDao
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow

class ShoppingRepositoryImpl(private val dao: ShoppingDao) : ShoppingRepository {
    override fun getShoppingItems(): Flow<List<ShoppingItem>> {
        return dao.getShoppingItems()
    }


    override suspend fun delete(item: ShoppingItem) {
        return dao.delete(item)
    }

    override suspend fun insert(item: ShoppingItem) {
        return dao.insert(item)
    }

}