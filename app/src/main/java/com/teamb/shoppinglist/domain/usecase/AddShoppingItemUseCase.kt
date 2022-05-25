package com.teamb.shoppinglist.domain.usecase

import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository

class AddShoppingItemUseCase(private val repository: ShoppingRepository) {

    suspend operator fun invoke(item: ShoppingItem) {
        repository.insert(item)
    }

}