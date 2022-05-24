package com.teamb.shoppinglist.presentation.shoppingdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.teamb.shoppinglist.domain.usecase.ShoppingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingDetailViewModel @Inject constructor(
    private val useCase: ShoppingUseCase
) : ViewModel() {

    private var _state = mutableStateOf(ShoppingDetailState())
    var state: State<ShoppingDetailState> = _state

}