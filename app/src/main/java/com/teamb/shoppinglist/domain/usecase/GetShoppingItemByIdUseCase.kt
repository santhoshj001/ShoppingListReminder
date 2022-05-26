package com.teamb.shoppinglist.domain.usecase

import com.teamb.shoppinglist.common.Resource
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetShoppingItemByIdUseCase(private val repository: ShoppingRepository) {
    operator fun invoke(itemId: Int): Flow<ShoppingItem>{
       return repository.getShoppingItemById(itemId)
    }
}