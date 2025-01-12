package com.items.ui.composables.ui.screens.buttonavegation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesBackNavigationButton
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.button.ComposesNavigationButton
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ButtonNavigationScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_button_navigation_screen),
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
        ButtonNavigationContent(paddingValues)
    }
}

@Composable
private fun ButtonNavigationContent(
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposesNavigationButton(
            textContent = stringResource(id = R.string.button_navigation),
            onClick = { }
        )
        ComposesNavigationButton(
            textContent = stringResource(id = R.string.button_navigation),
            enabled = false,
            onClick = { }
        )
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_default_navigation)
        )
        ComposesHorizontalDivider()
        ComposesBackNavigationButton(
            onClick = { }
        )

        ComposesBackNavigationButton(
            enabled = false,
            onClick = { }
        )
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_navigation_back)
        )
        ComposesHorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewButtonNavigationScreenLight() {
    val fragmentActivity = FragmentActivity()
    val navGo = NavGo(NavHostController(fragmentActivity))
    UicomposablesTheme {
        Surface {
            ButtonNavigationScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewButtonNavigationScreenDark() {
    val fragmentActivity = FragmentActivity()
    val navGo = NavGo(NavHostController(fragmentActivity))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            ButtonNavigationScreen(
                navGo = navGo
            )
        }
    }
}

private val TextPadding = 12.dp
