package com.teamb.shoppinglist.presentation.shoppinglist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.shoppinglist.common.Resource
import com.teamb.shoppinglist.domain.usecase.ShoppingUseCase
import com.teamb.shoppinglist.presentation.shoppingdetail.ShoppingListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingItemUseCase: ShoppingUseCase
) : ViewModel() {
    private var _state = mutableStateOf(ShoppingListState())
    var state: State<ShoppingListState> = _state

    init {
        getShoppingItems()
    }

    private fun getShoppingItems() {
        shoppingItemUseCase.getShoppingItemsUseCase().onEach {
            when (it) {
                is Resource.Error -> {
                    _state.value = ShoppingListState(error = "no items found")
                }
                is Resource.Loading -> {
                    _state.value = ShoppingListState(isLoading = true)

                }
                is Resource.Success -> {
                    _state.value = ShoppingListState(items = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}