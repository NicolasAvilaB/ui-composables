package com.items.ui.composables.ui.screens.switchscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import com.items.ui.switc.ComposesSwitch
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SwitchScreen(navGo: NavGo) {
    val onChange = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_switch_screen),
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
        SwitchContent(
            onChange = onChange,
            paddingValues = paddingValues
        )
    }
}

@Composable
private fun SwitchContent(
    onChange: MutableState<Boolean>,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        ComposesSwitch(
            text = stringResource(id = R.string.text_example),
            checked = onChange.value,
            onStateChange = { onChange.value = it }
        )
        ComposesText14(
            modifier = Modifier
                .padding(TextPadding)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.switch_default)
        )
        ComposesHorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSwitchScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            SwitchScreen(navGo = navGo)
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSwitchScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(darkTheme = true) {
        Surface {
            SwitchScreen(navGo = navGo)
        }
    }
}

private val TextPadding = 12.dp
