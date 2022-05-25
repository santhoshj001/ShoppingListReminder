package com.teamb.shoppinglist.domain.usecase.validation

import com.teamb.shoppinglist.common.ValidationResult
import com.teamb.shoppinglist.domain.model.ShoppingItem

class ItemQuantityValidationUseCase {
    operator fun invoke(itemQuantity: String): ValidationResult {
        if (itemQuantity.any { !it.isDigit() }) {
            return ValidationResult(false, "invalid quantity Enter a valid number")
        }
        if (itemQuantity.isBlank()) {
            return ValidationResult(false, "invalid quantity")
        }
        if (itemQuantity.toInt() <= 0) {
            return ValidationResult(false, "quantity needs to be greater that 1")
        }
        return ValidationResult(true)
    }
}


