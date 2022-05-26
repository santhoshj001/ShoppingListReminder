package com.teamb.shoppinglist.presentation.shoppinglist

import com.teamb.shoppinglist.domain.model.ShoppingItem

data class ShoppingListState(
    val items: List<ShoppingItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
