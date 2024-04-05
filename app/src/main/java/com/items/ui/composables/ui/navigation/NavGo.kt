package com.items.ui.composables.ui.navigation

import androidx.navigation.NavHostController

class NavGo (navHostController: NavHostController) {
    val loading: () -> Unit = {
        navHostController.navigate(NavRoutes.LoadingScreen.routes)
    }
}