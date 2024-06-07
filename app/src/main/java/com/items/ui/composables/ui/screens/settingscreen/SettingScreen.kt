package com.items.ui.composables.ui.screens.settingscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.switc.ComposesSwitch
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar
import androidx.compose.runtime.remember
import androidx.compose.material3.Scaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingScreen(
    navGo: NavGo,
    viewModel: SettingViewModel
) {
    val isDarkTheme = viewModel.darkTheme
    val darkThemeState = remember { mutableStateOf(isDarkTheme) }
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_setting_screen),
                    )
                },
                navigationButton = {
                    ComposesButtonArrowBack(
                        onClick = { navGo.popBackStack.invoke() },
                    )
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            ComposesSwitch(
                text = stringResource(id = R.string.label_darkmode),
                checked = darkThemeState.value,
                onStateChange = { booleanResult ->
                    darkThemeState.value = booleanResult
                    viewModel.darkTheme = booleanResult
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSettingScreenLight() {
    val context = LocalContext.current
    val viewModel = SettingViewModel()
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(darkTheme = false) {
        Surface {
            SettingScreen(
                navGo = navGo,
                viewModel = viewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSettingScreenDark() {
    val context = LocalContext.current
    val viewModel = SettingViewModel()
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(darkTheme = true) {
        Surface {
            SettingScreen(
                navGo = navGo,
                viewModel = viewModel
            )
        }
    }
}