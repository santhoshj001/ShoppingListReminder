package com.teamb.shoppinglist.presentation.shoppinglist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.shoppinglist.common.Resource
import com.teamb.shoppinglist.domain.usecase.ShoppingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingItemUseCase: ShoppingUseCase
) : ViewModel() {
    var state by mutableStateOf(ShoppingListState())
        private set

    init {
        getShoppingItems()
    }

    private fun getShoppingItems() {
        shoppingItemUseCase.getShoppingItemsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Error -> {
                    state = ShoppingListState(error = "no items found")
                }
                is Resource.Loading -> {
                    state = ShoppingListState(isLoading = true)
                }
                is Resource.Success -> {
                    resource.data?.let { items ->
                        state = ShoppingListState(items = items)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}