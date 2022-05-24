package com.teamb.shoppinglist.presentation.shoppingdetail

import com.teamb.shoppinglist.domain.model.ShoppingItem

data class ShoppingListState(
    val items: List<ShoppingItem>? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
