package com.items.ui.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18

@Composable
fun ComposesNumericInput(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    title: String,
    textValue: MutableState<String>,
    errorInput: Boolean = false,
    errorMessage: String = "",
    onValueChange: (String) -> Unit
) {
    val maxLength = 8
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ComposesText16(
            modifier = Modifier.padding(
                start = TitlePaddingTextAround,
                bottom = TitlePaddingTextAround,
                end = TitlePaddingTextAround
            ),
            text = title,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            placeholder = {
                ComposesText18(
                    text = stringResource(id = R.string.placeholder_your_must_enter_number)
                )
            },
            supportingText = {
                ComposesText16(
                    text = errorMessage
                )
            },
            shape = ShapeDefaults.Medium,
            value = textValue.value,
            singleLine = true,
            maxLines = 1,
            isError = errorInput,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            ),
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewNumericInputLight() {
    val passValue = remember { mutableStateOf("") }
    UicomposablesTheme {
        Surface {
            ComposesNumericInput(
                title = "Peso",
                textValue = passValue,
                onValueChange = { }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun PreviewNumericInputDark() {
    val passValue = remember { mutableStateOf("") }
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesNumericInput(
                title = "Peso",
                textValue = passValue,
                onValueChange = { }
            )
        }
    }
}

private val TitlePaddingTextAround = 8.dp
