package com.items.ui.composables.ui.navigation

import androidx.navigation.NavHostController

class NavGo (navHostController: NavHostController) {
    val buttonScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ButtonScreen.routes)
    }
    val buttonNavigationScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ButtonNavigationScreen.routes)
    }
    val buttonSwitchScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ButtonSwitchScreen.routes)
    }
    val drawScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.DrawScreen.routes)
    }
    val errorTemplateScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ErrorTemplateScreen.routes)
    }
    val loadingScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.LoadingScreen.routes)
    }
    val scanQrScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ScanQrScreen.routes)
    }
    val scanQrTextScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ScanQrTextScreen.routes)
    }
    val settingScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.SettingScreen.routes)
    }
    val textScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.TextScreen.routes)
    }
    val topbarScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.TopBarScreen.routes)
    }
    val popBackStack: () -> Unit = {
        navHostController.popBackStack()
    }
}