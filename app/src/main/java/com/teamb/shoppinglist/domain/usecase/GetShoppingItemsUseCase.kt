package com.teamb.shoppinglist.domain.usecase

import com.teamb.shoppinglist.common.Resource
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetShoppingItemsUseCase(private val repository: ShoppingRepository) {
    operator fun invoke(): Flow<Resource<List<ShoppingItem>>> = flow {
        try {
            emit(Resource.Loading())
            val items: List<ShoppingItem> = repository.getShoppingItems()
            emit(Resource.Success(items))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage))
        }
    }
}