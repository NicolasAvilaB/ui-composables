package com.items.ui.composables.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavController(fragmentActivity: FragmentActivity) {

    val navController = rememberNavController()
    val navGo = remember(navController) { NavGo(navController) }

    NavHost(
        navController = navController,
        startDestination = NavRoutes.MainScreen.routes
    )
    {
        mainScreen(navGo = navGo)
    }
}