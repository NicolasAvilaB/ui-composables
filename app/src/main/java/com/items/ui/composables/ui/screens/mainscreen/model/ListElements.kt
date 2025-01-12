package com.drivin.android.ui.screens.mainscreen.model

import android.content.Context
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composes.R

fun ListElements(
    context: Context,
    navGo: NavGo
) = arrayListOf(
    ItemsParams(
        label = context.getString(R.string.label_button_screen),
        navGoTo = { navGo.buttonScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_button_navigation_screen),
        navGoTo = { navGo.buttonNavigationScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_switch_screen),
        navGoTo = { navGo.buttonSwitchScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_draw_screen),
        navGoTo = { navGo.drawScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_spinner_screen),
        navGoTo = { navGo.spinnerScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_text_screen),
        navGoTo = { navGo.textScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_scanqr_screen),
        navGoTo = { navGo.scanQrScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_scanqrtext_screen),
        navGoTo = { navGo.scanQrTextScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_inputs_screen),
        navGoTo = { navGo.inputScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_loading_screen),
        navGoTo = { navGo.loadingScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_modal_screen),
        navGoTo = { navGo.modalScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_fail_screen),
        navGoTo = { navGo.errorTemplateScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_success_screen),
        navGoTo = { navGo.sucessTemplateScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_login_screen),
        navGoTo = { navGo.loginTemplateScreen.invoke() }
    ),
    ItemsParams(
        label = context.getString(R.string.label_topbar_screen),
        navGoTo = { navGo.topbarScreen.invoke() }
    )
)