package com.teamb.shoppinglist.presentation

sealed class ShoppingDetailFormEvent {
    data class ItemNameChanged(val itemName: String) : ShoppingDetailFormEvent()
    data class QuantityChanged(val quantity: String) : ShoppingDetailFormEvent()
    object RemoveItem : ShoppingDetailFormEvent()
    object SaveItem : ShoppingDetailFormEvent()
}
