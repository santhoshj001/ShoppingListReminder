package com.teamb.shoppinglist.common

import android.util.Log
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.presentation.shoppingdetail.ShoppingItemDetailState


fun ShoppingItemDetailState.toShoppingItem(): ShoppingItem {
    var quantity = 0
    try {
        quantity = itemQuantity.toInt()
    } catch (e: Exception) {
        Log.i("ShoppingItemExt", "toShoppingItem:  " + e.localizedMessage)

    }
    return ShoppingItem(
        id = 0,
        name = itemName,
        quantity = quantity,
        unit = selectedOption,
        timestamp = System.currentTimeMillis()
    )
}