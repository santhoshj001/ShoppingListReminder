package com.teamb.shoppinglist.domain.usecase

import com.teamb.shoppinglist.common.isValid
import com.teamb.shoppinglist.domain.model.InvalidException
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository

class UpdateShoppingItemUseCase(private val repository: ShoppingRepository) {
    suspend operator fun invoke(item: ShoppingItem) {
        if (!item.isValid()) {
            throw InvalidException("the title of a note can't be empty ")
        }
        repository.insert(item)
    }
}