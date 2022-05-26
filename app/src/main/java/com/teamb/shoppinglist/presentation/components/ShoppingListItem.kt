package com.teamb.shoppinglist.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teamb.shoppinglist.domain.model.ShoppingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListItem(item: ShoppingItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(

            ) {

                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                AssistChip(
                    onClick = {},
                    label = { Text("${item.quantity} ${item.unit}") }
                )
            }

            AssistChip(
                onClick = {},
                label = { Text("Edit") },
                leadingIcon = {
                    Icon(Icons.Outlined.Edit, contentDescription = "Edit")
                }
            )

            /*AssistChip(
                onClick = {},
                label = { Text("Done") },
                leadingIcon = {
                    Icon(Icons.Default.Check, contentDescription = "done")
                }
            )*/
        }
    }
}