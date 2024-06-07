package com.items.ui.composables.ui.screens.buttonscreen

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R.drawable.ic_call_answer_low
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.button.ComposesSecondaryButton
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.selectitem.ComposesSelectItem
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ButtonScreen(
    fragmentActivity: FragmentActivity,
    navGo: NavGo
) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_button_screen),
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
        ButtonContent(paddingValues, fragmentActivity)
    }
}

@Composable
private fun ButtonContent(
    paddingValues: PaddingValues,
    fragmentActivity: FragmentActivity
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposesPrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            onClick = {
                showToast(
                    fragmentActivity.getString(R.string.button_primary),
                    fragmentActivity
                )
            },
            textContent = stringResource(id = R.string.button_primary)
        )
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_primary_actions)
        )
        ComposesHorizontalDivider()
        ComposesSecondaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            onClick = {
                showToast(
                    fragmentActivity.getString(R.string.button_secondary),
                    fragmentActivity
                )
            },
            textContent = stringResource(id = R.string.button_secondary)
        )
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_secondary_actions)
        )
        ComposesHorizontalDivider()
        ComposesPrimaryButton(
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            onClick = { },
            textContent = stringResource(id = R.string.button_primary)
        )
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_primary_disabled)
        )
        ComposesHorizontalDivider()
        ComposesSecondaryButton(
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            onClick = { },
            textContent = stringResource(id = R.string.button_secondary)
        )
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_secondary_disabled)
        )
        ComposesHorizontalDivider()
        ComposesSelectItem(
            text = stringResource(id = R.string.menuitem),
            icon = ic_call_answer_low
        ) {
            showToast(
                fragmentActivity.getString(R.string.button_menuitem),
                fragmentActivity
            )
        }
        ComposesText14(
            modifier = Modifier.padding(TextPadding),
            text = stringResource(id = R.string.button_menuitem)
        )
        ComposesHorizontalDivider()
    }
}

private fun showToast(
    message: String,
    context: Context
) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
internal fun PreviewButtonScreenLight() {
    val fragmentActivity = FragmentActivity()
    val navGo = NavGo(NavHostController(fragmentActivity))
    UicomposablesTheme {
        Surface {
            ButtonScreen(
                navGo = navGo,
                fragmentActivity = fragmentActivity
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewButtonScreenDark() {
    val fragmentActivity = FragmentActivity()
    val navGo = NavGo(NavHostController(fragmentActivity))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            ButtonScreen(
                navGo = navGo,
                fragmentActivity = fragmentActivity
            )
        }
    }
}

private val TextPadding = 12.dp
