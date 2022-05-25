package com.teamb.shoppinglist.domain.usecase.validation

data class ValidationUseCase(
    val itemNameValidationUseCase: ItemNameValidationUseCase,
    val itemQuantityValidationUseCase: ItemQuantityValidationUseCase
)
