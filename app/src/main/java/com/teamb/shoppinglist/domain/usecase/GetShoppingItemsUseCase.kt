package com.teamb.shoppinglist.domain.usecase

import com.teamb.shoppinglist.common.Resource
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetShoppingItemsUseCase(private val repository: ShoppingRepository) {
    operator fun invoke(): Flow<List<ShoppingItem>>{
       return repository.getShoppingItems()
    }
}