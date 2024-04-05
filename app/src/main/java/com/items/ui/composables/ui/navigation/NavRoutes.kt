package com.items.ui.composables.ui.navigation

sealed class NavRoutes(var routes: String){
    object MainScreen: NavRoutes("MainScreen")
    object LoadingScreen: NavRoutes("LoadingScreen")
}