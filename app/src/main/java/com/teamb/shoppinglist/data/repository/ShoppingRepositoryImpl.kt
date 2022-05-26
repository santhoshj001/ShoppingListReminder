package com.teamb.shoppinglist.data.repository

import com.teamb.shoppinglist.data.data_source.dao.ShoppingDao
import com.teamb.shoppinglist.domain.model.DeleteShoppingItem
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow

class ShoppingRepositoryImpl(private val dao: ShoppingDao) : ShoppingRepository {
    override fun getShoppingItems(): Flow<List<ShoppingItem>> {
        return dao.getShoppingItems()
    }

    override  fun getShoppingItemById(itemId: Int) : Flow<ShoppingItem> {
        return dao.getShoppingItemByID(itemId)
    }


    override suspend fun delete(itemId: Int) {
        return dao.delete(DeleteShoppingItem(id = itemId))
    }

    override suspend fun insert(item: ShoppingItem) {
        return dao.insert(item)
    }

}