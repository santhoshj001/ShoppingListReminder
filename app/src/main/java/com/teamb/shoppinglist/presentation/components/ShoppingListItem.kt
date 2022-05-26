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
import androidx.navigation.NavController
import com.teamb.shoppinglist.common.Constants
import com.teamb.shoppinglist.domain.model.ShoppingItem
import com.teamb.shoppinglist.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListItem(item: ShoppingItem, navController: NavController) {
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
                onClick = {
                    navController.navigate(
                        Screen.ShoppingDetailScreen.route + "?${Constants.NAV_ITEM_ID}=${item.id}"
                    )
                },
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