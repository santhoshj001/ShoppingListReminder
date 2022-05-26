package com.teamb.shoppinglist.presentation.shoppinglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teamb.shoppinglist.presentation.Screen
import com.teamb.shoppinglist.presentation.components.ShoppingListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(
    navController: NavController,
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.ShoppingDetailScreen.route) }) {
                Icon(Icons.Outlined.Add, "")
            }
        }, content = { innerPadding ->

            LazyColumn(contentPadding = innerPadding) {
                item {
                    CenterAlignedTopAppBar({
                        Text(text = "Shopping Items")
                    })
                }
                items(items = state.items) {
                    ShoppingListItem(it)
                }
            }
        }
    )


}