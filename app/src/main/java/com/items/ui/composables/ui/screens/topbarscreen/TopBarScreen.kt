package com.items.ui.composables.ui.screens.topbarscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesCenterAppBar
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBarScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_topbar_screen),
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
        TopBarContent(paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        ComposesText18(
            modifier = Modifier.padding(bottom = 16.dp),
            text = stringResource(id = R.string.header_topbar)
        )
        ComposesTopAppBar(
            color = Color.Blue,
            titleColor = MaterialTheme.colorScheme.onPrimary,
            title = {
                ComposesText18(
                    text = stringResource(id = R.string.label_topbar_screen)
                )
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        ComposesCenterAppBar(
            color = Color.Red,
            titleColor = MaterialTheme.colorScheme.primary,
            title = {
                ComposesText18(
                    text = stringResource(id = R.string.label_topbar_screen)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            TopBarScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            TopBarScreen(
                navGo = navGo
            )
        }
    }
}