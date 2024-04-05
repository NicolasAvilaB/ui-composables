package com.items.ui.composables.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.items.ui.composables.ui.main.MainScreen

internal fun NavGraphBuilder.mainScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.MainScreen.routes
) {
    MainScreen(navGo = navGo)
}