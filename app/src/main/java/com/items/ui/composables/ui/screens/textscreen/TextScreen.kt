package com.items.ui.composables.ui.screens.textscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composes.R
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18
import com.items.ui.text.ComposesText20
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TextScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_text_screen),
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
        TextContent(paddingValues)
    }
}

@Composable
private fun TextContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        ComposesText20(
            modifier = Modifier.padding(PaddingSpacingText),
            text = "Body 1"
        )
        ComposesHorizontalDivider()
        ComposesText18(
            modifier = Modifier.padding(PaddingSpacingText),
            text = "Body 2"
        )
        ComposesHorizontalDivider()
        ComposesText16(
            modifier = Modifier.padding(PaddingSpacingText),
            text = "Body 3"
        )
        ComposesHorizontalDivider()
        ComposesText14(
            modifier = Modifier.padding(PaddingSpacingText),
            text = "Body 4"
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
            TextScreen(
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
            TextScreen(
                navGo = navGo
            )
        }
    }
}

private val PaddingSpacingText = 16.dp
