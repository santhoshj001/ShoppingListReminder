package com.teamb.shoppinglist.presentation.shoppingdetail

data class ShoppingItemDetailState(

    val tile: String = "Shopping Details",
    val itemName: String = "",
    val itemNameError: String? = null,
    val quantity: String = "",
    val quantityError: String? = null,
    val isRemoveEnabled: Boolean = false,
    val options: List<Units> = listOf(
        Units.Kilogram,
        Units.Gram,
        Units.Litre,
        Units.MilliLitre,
        Units.Count
    ),
    val selectedOption: String = options.first().UnitName
)
