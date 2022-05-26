package com.teamb.shoppinglist.presentation.shoppingdetail

sealed class ShoppingDetailFormEvent {
    data class ItemNameChanged(val itemName: String) : ShoppingDetailFormEvent()
    data class QuantityChanged(val quantity: String) : ShoppingDetailFormEvent()
    data class UnitChanged(val UnitName: String) : ShoppingDetailFormEvent()
    object RemoveItem : ShoppingDetailFormEvent()
    object SaveItem : ShoppingDetailFormEvent()
}
