package com.za.groceryappui.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.za.groceryappui.Screen
import com.za.groceryappui.ui.mainScreen.MainScreen
import com.za.groceryappui.ui.splash.Splash1
import com.za.groceryappui.ui.splash.Splash2
import com.za.groceryappui.ui.splash.Splash3
import com.za.groceryappui.ui.splash.Splash4
import com.za.groceryappui.ui.theme.GroceryAppUITheme

@RequiresApi(Build.VERSION_CODES.Q)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppUITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(
                            route = Screen.Splash1Screen.route
                        ) {
                            Splash1(navController)
                        }
                        composable(
                            route = Screen.Splash2Screen.route
                        ) {
                            Splash2(navController)
                        }
                        composable(
                            route = Screen.Splash3Screen.route
                        ) {
                            Splash3(navController)
                        }
                        composable(
                            route = Screen.Splash4Screen.route
                        ) {
                            Splash4()
                        }
                        composable(
                            route = Screen.MainScreen.route
                        ) {
                            MainScreen()
                        }
                    }
                }
            }
        }
    }
}
