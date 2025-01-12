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
    val loginTemplateScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.LoginTemplateScreen.routes)
    }
    val errorTemplateScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ErrorTemplateScreen.routes)
    }
    val sucessTemplateScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.SuccessTemplateScreen.routes)
    }
    val inputScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.InputScreen.routes)
    }
    val loadingScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.LoadingScreen.routes)
    }
    val modalScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.ModalScreen.routes)
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
    val spinnerScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.SpinnerScreen.routes)
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