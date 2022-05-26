package com.teamb.shoppinglist.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teamb.shoppinglist.domain.model.ShoppingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListItem(item: ShoppingItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row(Modifier.padding(12.dp)) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = item.quantity.toString(),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}