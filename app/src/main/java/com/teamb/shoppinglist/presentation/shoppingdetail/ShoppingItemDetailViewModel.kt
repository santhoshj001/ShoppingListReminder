package com.teamb.shoppinglist.presentation.shoppingdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.domain.usecase.ShoppingUseCase
import com.teamb.shoppinglist.domain.usecase.validation.ValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingItemDetailViewModel @Inject constructor(
    private val shoppingUseCase: ShoppingUseCase,
    private val validationUseCase: ValidationUseCase
) : ViewModel() {

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
                state = state.copy(quantity = event.quantity)
            }
            is ShoppingDetailFormEvent.UnitChanged -> {
                state = state.copy(selectedOption = event.UnitName)
            }
            ShoppingDetailFormEvent.RemoveItem -> onRemoveItem()
            ShoppingDetailFormEvent.SaveItem -> onSaveItem()
        }
    }

    private fun onRemoveItem() {
        TODO()
    }

    private fun onSaveItem() {
        val nameResult = validationUseCase.itemNameValidationUseCase(state.itemName)
        val quantityResult = validationUseCase.itemQuantityValidationUseCase(state.quantity)

        val hasError = listOf(nameResult, quantityResult).any { !it.isSuccess }
        if (hasError) {
            state = state.copy(
                itemNameError = nameResult.errorMessage,
                quantityError = quantityResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            shoppingUseCase.addShoppingItemUseCase(
                ShoppingItem(
                    name = state.itemName,
                    quantity = state.quantity.toInt(),
                    timestamp = System.currentTimeMillis(),
                    unit = state.selectedOption
                )
            )
            validationEventChannel.send(ValidationEvent.Success)
        }
    }


    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

}