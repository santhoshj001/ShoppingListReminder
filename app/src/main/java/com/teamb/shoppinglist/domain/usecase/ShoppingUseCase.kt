package com.teamb.shoppinglist.domain.usecase

data class ShoppingUseCase(
    val addShoppingItemUseCase: AddShoppingItemUseCase,
    val deleteShoppingItemUseCase: DeleteShoppingItemUseCase,
    val updateShoppingItemUseCase: UpdateShoppingItemUseCase,
    val getShoppingItemsUseCase: GetShoppingItemsUseCase,
    val getShoppingItemByIdUseCase: GetShoppingItemByIdUseCase
)
