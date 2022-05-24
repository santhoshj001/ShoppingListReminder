package com.teamb.shoppinglist.presentation.shoppingdetail

import android.service.quicksettings.Tile
import com.teamb.shoppinglist.domain.model.ShoppingItem

data class ShoppingDetailState(
    val item: ShoppingItem? = null,
    val tile: String = "Shopping Details"
)
