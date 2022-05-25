package com.teamb.shoppinglist.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.teamb.shoppinglist.presentation.ShoppingDetailFormEvent
import com.teamb.shoppinglist.presentation.shoppingdetail.ShoppingDetailViewModel


@Composable
fun ShoppingItemDetailScreen(viewModel: ShoppingDetailViewModel = hiltViewModel()) {

    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect {
            when (it) {
                ShoppingDetailViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "success",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    Column {
        CenterAlignedTopAppBar({
            Text(text = "Add Shopping Items")
        })
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(
                value = state.itemName,
                onValueChange = {
                    viewModel.onEvent(
                        ShoppingDetailFormEvent.ItemNameChanged(it)
                    )
                },
                isError = state.itemNameError != null,
                label = { Text("Item Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            )

            if (state.itemNameError != null && state.itemNameError.isNotBlank()) {
                Text(
                    text = state.itemNameError,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
            OutlinedTextField(
                value = state.quantity,
                onValueChange = {
                    viewModel.onEvent(
                        ShoppingDetailFormEvent.QuantityChanged(it)
                    )
                },
                isError = state.quantityError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Item Quantity") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            if (state.quantityError != null && state.quantityError.isNotBlank()) {
                Text(
                    text = state.quantityError,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                if (state.isRemoveEnabled) {
                    OutlinedButton(

                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(text = "Remove", fontSize = 18.sp)
                    }
                }
                OutlinedButton(
                    onClick = { viewModel.onEvent(ShoppingDetailFormEvent.SaveItem) },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Save", fontSize = 18.sp)
                }
            }
        }
    }
}
