package com.teamb.shoppinglist.domain.usecase.validation

import com.teamb.shoppinglist.common.ValidationResult
import com.teamb.shoppinglist.domain.model.ShoppingItem

class ItemNameValidationUseCase {
    operator fun invoke(itemName: String): ValidationResult {
        if (itemName.isBlank()) {
            return ValidationResult(false, "ItemName can't be blank")
        }
        return ValidationResult(true)
    }
}


