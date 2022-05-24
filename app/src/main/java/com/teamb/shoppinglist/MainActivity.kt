package com.teamb.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teamb.shoppinglist.presentation.Screen
import com.teamb.shoppinglist.presentation.components.ShoppingItemDetailScreen
import com.teamb.shoppinglist.presentation.shoppinglist.ShoppingListScreen
import com.teamb.shoppinglist.ui.theme.ShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme(darkTheme = true) {
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
                            Screen.ShoppingDetailScreen.route
                        ) {
                            ShoppingItemDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShoppingListTheme {
        Greeting("Android")
    }
}

