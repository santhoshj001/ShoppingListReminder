package com.teamb.shoppinglist.presentation.shoppingdetail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.shoppinglist.common.Constants
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.usecase.ShoppingUseCase
import com.teamb.shoppinglist.domain.usecase.validation.ValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingItemDetailViewModel @Inject constructor(
    private val shoppingUseCase: ShoppingUseCase,
    private val validationUseCase: ValidationUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        savedStateHandle.get<Int>(Constants.NAV_ITEM_ID)?.let { id ->
            Log.i("sjdroid", "$id ")
            if (id != -1) {
                shoppingUseCase.getShoppingItemByIdUseCase(id).onEach { shoppingItem ->
                    shoppingItem?.let {
                        state = state.copy(
                            id = shoppingItem.id,
                            itemName = shoppingItem.name,
                            itemQuantity = shoppingItem.quantity.toString(),
                            selectedUnitOption = shoppingItem.unit,
                            isRemoveEnabled = true
                        )
                    }
                }.launchIn(viewModelScope)
            }
        }
    }

    var state by mutableStateOf(ShoppingItemDetailState())
        private set

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: ShoppingDetailFormEvent) {
        when (event) {
            is ShoppingDetailFormEvent.ItemNameChanged -> {
                state = state.copy(itemName = event.itemName)
            }
            is ShoppingDetailFormEvent.QuantityChanged -> {
                state = state.copy(itemQuantity = event.quantity)
            }
            is ShoppingDetailFormEvent.UnitChanged -> {
                state = state.copy(selectedUnitOption = event.UnitName)
            }
            ShoppingDetailFormEvent.RemoveItem -> onRemoveItem()
            ShoppingDetailFormEvent.SaveItem -> onSaveItem()
        }
    }

    private fun onRemoveItem() {
        viewModelScope.launch {
            state.id?.let {
                shoppingUseCase.deleteShoppingItemUseCase(itemId = it)
                validationEventChannel.send(ValidationEvent.Success)
            }
        }
    }

    private fun onSaveItem() {
        val nameResult = validationUseCase.itemNameValidationUseCase(state.itemName)
        val quantityResult = validationUseCase.itemQuantityValidationUseCase(state.itemQuantity)

        val hasError = listOf(nameResult, quantityResult).any { !it.isSuccess }
        if (hasError) {
            state = state.copy(
                itemNameError = nameResult.errorMessage,
                itemQuantityError = quantityResult.errorMessage
            )
            return
        }
        viewModelScope.launch {

            if (state.id != null) {
                shoppingUseCase.updateShoppingItemUseCase(
                    ShoppingItem(
                        id = state.id!!,
                        name = state.itemName,
                        quantity = state.itemQuantity.toInt(),
                        timestamp = System.currentTimeMillis(),
                        unit = state.selectedUnitOption
                    )
                )
            } else {
                shoppingUseCase.addShoppingItemUseCase(
                    ShoppingItem(
                        name = state.itemName,
                        quantity = state.itemQuantity.toInt(),
                        timestamp = System.currentTimeMillis(),
                        unit = state.selectedUnitOption
                    )
                )
            }
            validationEventChannel.send(ValidationEvent.Success)
        }
    }


    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

}