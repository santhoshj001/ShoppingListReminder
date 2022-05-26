package com.teamb.shoppinglist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingItem(
    val name: String,
    val quantity: Int,
    val timestamp: Long,
    val unit: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
