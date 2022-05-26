package com.teamb.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.teamb.shoppinglist.common.Constants
import com.teamb.shoppinglist.presentation.Screen
import com.teamb.shoppinglist.presentation.shoppingdetail.ShoppingItemDetailScreen
import com.teamb.shoppinglist.presentation.shoppinglist.ShoppingListScreen
import com.teamb.shoppinglist.ui.theme.ShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ShoppingListScreen.route
                    ) {
                        composable(
                            route = Screen.ShoppingListScreen.route
                        ) {
                            ShoppingListScreen(navController = navController)
                        }
                        composable(
                            Screen.ShoppingDetailScreen.route + "?${Constants.NAV_ITEM_ID}={itemId}",
                            arguments = listOf(
                                navArgument(name = Constants.NAV_ITEM_ID) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                })
                        ) {
                            ShoppingItemDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

