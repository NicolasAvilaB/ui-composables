package com.items.ui.composables.ui.loading

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.loading.ComposesCentralLoading
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoadingScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = "UI Loading",
                        color = Color.White,
                    )
                },
                navigationButton = {
                    ComposesButtonArrowBack(
                        onClick = { navGo.popBackStack.invoke() },
                        color = Color.White
                    )
                }
            )
        },
    ) { paddingValues ->
        paddingValues.calculateBottomPadding()
        ComposesCentralLoading()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            LoadingScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            LoadingScreen(
                navGo = navGo
            )
        }
    }
}