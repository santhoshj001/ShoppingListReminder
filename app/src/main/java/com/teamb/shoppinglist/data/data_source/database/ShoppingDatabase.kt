package com.teamb.shoppinglist.data.data_source.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.teamb.shoppinglist.data.data_source.dao.ShoppingDao
import com.teamb.shoppinglist.domain.model.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract val shoppingDao: ShoppingDao

    companion object {
        const val DATABASE_NAME = "shopping_items_db"
    }
}