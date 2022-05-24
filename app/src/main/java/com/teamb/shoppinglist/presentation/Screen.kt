package com.teamb.shoppinglist.presentation

sealed class Screen( val route :String) {
    object ShoppingListScreen : Screen("shopping_list_screen")
    object ShoppingDetailScreen : Screen("shopping_detail_screen")
}
