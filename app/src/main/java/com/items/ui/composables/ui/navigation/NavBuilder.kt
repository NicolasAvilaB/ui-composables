package com.items.ui.composables.ui.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.items.ui.composables.ui.screens.buttonavigationscreen.ButtonNavigationScreen
import com.items.ui.composables.ui.screens.buttonscreen.ButtonScreen
import com.items.ui.composables.ui.screens.drawcontainerscreen.DrawScreen
import com.items.ui.composables.ui.screens.errortemplatescreen.ErrorTemplateScreen
import com.items.ui.composables.ui.screens.loadingscreen.LoadingScreen
import com.items.ui.composables.ui.screens.indexscreen.IndexMainScreen
import com.items.ui.composables.ui.screens.scanqrscreen.ScanQrBarcodeScreen
import com.items.ui.composables.ui.screens.scanqrscreen.ScanQrTextScreen
import com.items.ui.composables.ui.screens.settingscreen.SettingScreen
import com.items.ui.composables.ui.screens.settingscreen.SettingViewModel
import com.items.ui.composables.ui.screens.switchscreen.SwitchScreen
import com.items.ui.composables.ui.screens.textscreen.TextScreen
import com.items.ui.composables.ui.screens.topbarscreen.TopBarScreen

internal fun NavGraphBuilder.mainScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.MainScreen.routes
) {
    IndexMainScreen(navGo = navGo)
}

internal fun NavGraphBuilder.buttonScreen(
    fragmentActivity: FragmentActivity,
    navGo: NavGo
) = composable(
    route = NavRoutes.ButtonScreen.routes
) {
    ButtonScreen(
        fragmentActivity = fragmentActivity,
        navGo = navGo
    )
}

internal fun NavGraphBuilder.buttonNavigation(
    navGo: NavGo
) = composable(
    route = NavRoutes.ButtonNavigationScreen.routes
) {
    ButtonNavigationScreen(
        navGo = navGo
    )
}

internal fun NavGraphBuilder.buttonSwitch(
    navGo: NavGo
) = composable(
    route = NavRoutes.ButtonSwitchScreen.routes
) {
    SwitchScreen(
        navGo = navGo
    )
}

internal fun NavGraphBuilder.drawScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.DrawScreen.routes
) {
    DrawScreen(navGo = navGo)
}

internal fun NavGraphBuilder.failScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.ErrorTemplateScreen.routes
) {
    ErrorTemplateScreen(navGo = navGo)
}


internal fun NavGraphBuilder.loadingScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.LoadingScreen.routes
) {
    LoadingScreen(navGo = navGo)
}

internal fun NavGraphBuilder.scanQrScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.ScanQrScreen.routes
) {
    ScanQrBarcodeScreen(navGo = navGo)
}

internal fun NavGraphBuilder.scanQrTextScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.ScanQrTextScreen.routes
) {
    ScanQrTextScreen(navGo = navGo)
}

internal fun NavGraphBuilder.settingScreen(
    navGo: NavGo,
    viewModel: SettingViewModel
) = composable(
    route = NavRoutes.SettingScreen.routes
) {
    SettingScreen(
        navGo = navGo,
        viewModel = viewModel
    )
}

internal fun NavGraphBuilder.textScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.TextScreen.routes
) {
    TextScreen(navGo = navGo)
}

internal fun NavGraphBuilder.topbarScreen(
    navGo: NavGo
) = composable(
    route = NavRoutes.TopBarScreen.routes
) {
    TopBarScreen(navGo = navGo)
}
