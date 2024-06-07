package com.items.ui.composables.ui.navigation

sealed class NavRoutes(var routes: String){
    object ButtonScreen: NavRoutes("ButtonScreen")
    object ButtonNavigationScreen: NavRoutes("ButtonNavigationScreen")
    object ButtonSwitchScreen: NavRoutes("ButtonSwitchScreen")
    object DrawScreen: NavRoutes("DrawScreen")
    object ErrorTemplateScreen: NavRoutes("ErrorTemplateScreen")
    object LoadingScreen: NavRoutes("LoadingScreen")
    object MainScreen: NavRoutes("MainScreen")
    object ScanQrScreen: NavRoutes("ScanQrBarcodeScreen")
    object ScanQrTextScreen: NavRoutes("ScanQrTextScreen")
    object SettingScreen: NavRoutes("SettingScreen")
    object TextScreen: NavRoutes("TextScreen")
    object TopBarScreen: NavRoutes("TopBarScreen")
}