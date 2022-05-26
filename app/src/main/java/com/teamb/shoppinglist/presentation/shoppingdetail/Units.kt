package com.teamb.shoppinglist.presentation.shoppingdetail

sealed class Units(val UnitName: String) {
    object Kilogram : Units("Kilogram")
    object Gram : Units("Gram")
    object Litre : Units("Litre")
    object MilliLitre : Units("MilliLitre")
    object Count : Units("Count")
}
