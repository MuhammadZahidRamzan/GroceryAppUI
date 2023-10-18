package com.za.groceryappui

sealed class Screen(val route: String) {
    object Splash1Screen: Screen("splash1_screen")
    object Splash2Screen: Screen("splash2_screen")
    object Splash3Screen: Screen("splash3_screen")
    object Splash4Screen: Screen("splash4_screen")
    object MainScreen: Screen("main_screen")
}