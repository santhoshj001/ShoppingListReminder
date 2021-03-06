package com.teamb.shoppinglist.data.data_source.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.teamb.shoppinglist.domain.model.DeleteShoppingItem
import com.teamb.shoppinglist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {

    @Query("SELECT * from ShoppingItem")
    fun getShoppingItems(): Flow<List<ShoppingItem>>

    @Query("SELECT * from ShoppingItem where id = :id")
    fun getShoppingItemByID(id: Int): Flow<ShoppingItem>

    @Insert(onConflict = REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete(entity = ShoppingItem::class)
    suspend fun delete(vararg idToDelete: DeleteShoppingItem)

}