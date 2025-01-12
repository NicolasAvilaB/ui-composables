package com.items.ui.composables.ui.screens.successcreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.successtemplate.ComposesSuccessTemplate
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SuccessTemplateScreen(
    navGo: NavGo
) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_success_screen),
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
            ComposesSuccessTemplate(
                textTitle =
                stringResource(id = R.string.title_good_screen),
                textSubtitle =
                stringResource(id = R.string.subtitle_operation_completed_successful_screen),
                textButton = stringResource(id = R.string.accept),
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewErrorTemplateScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            SuccessTemplateScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewErrorTemplateScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            SuccessTemplateScreen(
                navGo = navGo
            )
        }
    }
}