package com.teamb.shoppinglist.presentation.shoppinglist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.shoppinglist.domain.usecase.ShoppingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingItemUseCase: ShoppingUseCase
) : ViewModel() {
    var state by mutableStateOf(ShoppingListState())
        private set

    private var getShoppingItemsJob: Job? = null

    init {
        getShoppingItems()
    }

    private fun getShoppingItems() {
        getShoppingItemsJob?.cancel()
        getShoppingItemsJob = shoppingItemUseCase.getShoppingItemsUseCase().onEach { list ->
            if (list.isEmpty()) {
                state = state.copy(isLoading = false, error = "no items Found")
            } else {
                state = state.copy(items = list)
            }
        }.launchIn(viewModelScope)
    }
}