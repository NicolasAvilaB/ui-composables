package com.items.ui.composables.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.items.ui.composables.ui.loading.LoadingScreen
import com.items.ui.composables.ui.indexscreen.IndexMainScreen

internal fun NavGraphBuilder.mainScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.MainScreen.routes
) {
    IndexMainScreen(navGo = navGo)
}

internal fun NavGraphBuilder.loadingScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.LoadingScreen.routes
) {
    LoadingScreen(navGo = navGo)
}