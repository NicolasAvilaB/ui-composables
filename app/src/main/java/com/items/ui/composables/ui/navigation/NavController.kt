package com.items.ui.composables.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.items.ui.composables.ui.screens.settingscreen.SettingViewModel

@Composable
fun NavController(
    fragmentActivity: FragmentActivity,
    viewModel: SettingViewModel
) {

    val navController = rememberNavController()
    val navGo = remember(navController) { NavGo(navController) }

    NavHost(
        navController = navController,
        startDestination = NavRoutes.MainScreen.routes
    ) {
        buttonNavigation(navGo = navGo)
        buttonScreen(fragmentActivity = fragmentActivity, navGo = navGo)
        buttonSwitch(navGo = navGo)
        drawScreen(navGo = navGo)
        failScreen(navGo = navGo)
        loadingScreen(navGo = navGo)
        mainScreen(navGo = navGo)
        scanQrScreen(navGo = navGo)
        scanQrTextScreen(navGo = navGo)
        settingScreen(
            navGo = navGo,
            viewModel = viewModel
        )
        textScreen(navGo = navGo)
        topbarScreen(navGo = navGo)
    }
}