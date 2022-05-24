package com.teamb.shoppinglist.presentation.shoppinglist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teamb.shoppinglist.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(
    navController: NavController,
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.ShoppingDetailScreen.route) }) {
                Icon(Icons.Outlined.Add, "")
            }
        }, content = { innerPadding ->
            CenterAlignedTopAppBar({
                Text(text = "Shopping Items")
            })

            LazyColumn(contentPadding = innerPadding) {
                items(count = 100) {
                    Box(
                        Modifier.fillMaxSize()
                    ) {
                        val state = viewModel.state
                    }
                }
            }
        }
    )


}