package com.items.ui.composables.ui.screens.inputscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
import com.items.ui.input.ComposesEmailInput
import com.items.ui.input.ComposesNumericInput
import com.items.ui.input.ComposesNumericPasswordInput
import com.items.ui.input.ComposesOutlinedTextInput
import com.items.ui.input.ComposesPasswordInput
import com.items.ui.input.model.CustomKeyboardTypeText
import com.items.ui.input.model.KeyboardOptionsTypeText
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun InputScreen(navGo: NavGo) {
    val passValue = remember { mutableStateOf("") }
    val numberPassValue = remember { mutableStateOf("") }
    val numberErrorPassValue = remember { mutableStateOf("") }
    val errorPassValue = remember { mutableStateOf("") }
    val inputValue = remember { mutableStateOf("") }
    val numberValue = remember { mutableStateOf("") }
    val textValueInput = remember { mutableStateOf("") }
    val errorInputValue = remember { mutableStateOf("") }
    val errorInput = false
    val errorMessage = ""
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_inputs_screen),
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
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComposesEmailInput(
                errorInput = errorInput,
                errorMessage = errorMessage,
                inputValue = inputValue,
                onValueChange = { }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_email)
            )
            ComposesHorizontalDivider()
            ComposesEmailInput(
                modifier = Modifier.padding(top = 40.dp),
                errorInput = true,
                errorMessage =
                stringResource(
                    id = R.string.your_must_enter_email
                ),
                inputValue = errorInputValue,
                onValueChange = { }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_email_error)
            )
            ComposesHorizontalDivider()
            ComposesPasswordInput(
                modifier = Modifier.padding(top = 40.dp),
                errorInput = errorInput,
                errorMessage = errorMessage,
                passValue = passValue,
                onValueChange = { }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_pass)
            )
            ComposesHorizontalDivider()
            ComposesPasswordInput(
                modifier = Modifier.padding(top = 40.dp),
                errorInput = true,
                errorMessage =
                stringResource(
                    id = R.string.your_must_enter_pass
                ),
                passValue = errorPassValue,
                onValueChange = {

                }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_pass_error)
            )
            ComposesHorizontalDivider()
            ComposesNumericPasswordInput(
                modifier = Modifier.padding(top = 40.dp),
                errorInput = errorInput,
                errorMessage = errorMessage,
                passValue = numberPassValue,
                onValueChange = { }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_pass)
            )
            ComposesHorizontalDivider()
            ComposesNumericPasswordInput(
                modifier = Modifier.padding(top = 40.dp),
                errorInput = true,
                errorMessage =
                stringResource(
                    id = R.string.your_must_enter_pass
                ),
                passValue = numberErrorPassValue,
                onValueChange = { }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_pass_error)
            )
            ComposesHorizontalDivider()
            ComposesNumericInput(
                modifier = Modifier.padding(top = 40.dp),
                textValue = numberValue,
                title = stringResource(id = R.string.label_weight_input),
                onValueChange = { }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_number)
            )
            ComposesHorizontalDivider()

            ComposesOutlinedTextInput(
                modifier = Modifier.padding(top = 40.dp),
                title = stringResource(id = R.string.label_email_input),
                textValue = textValueInput,
                placeHolder = stringResource(id = R.string.placeholder_email_input),
                keyboardOptionsType = KeyboardOptionsTypeText(CustomKeyboardTypeText.Text),
                onValueChange = {

                }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.input_default_generic)
            )
            ComposesHorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLoadingScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            InputScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLoadingScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            InputScreen(
                navGo = navGo
            )
        }
    }
}

private val TextPaddingTopDivider = 12.dp