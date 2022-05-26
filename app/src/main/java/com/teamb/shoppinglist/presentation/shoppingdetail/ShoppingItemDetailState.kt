package com.teamb.shoppinglist.presentation.shoppingdetail

data class ShoppingItemDetailState(
    val id: Int? = null,
    val tile: String = "Shopping Details",
    val itemName: String = "",
    val itemNameError: String? = null,
    val itemQuantity: String = "",
    val itemQuantityError: String? = null,
    val isRemoveEnabled: Boolean = false,
    val options: List<Units> = listOf(
        Units.Kilogram,
        Units.Gram,
        Units.Litre,
        Units.MilliLitre,
        Units.Count
    ),
    val selectedUnitOption: String = options.first().UnitName
)
