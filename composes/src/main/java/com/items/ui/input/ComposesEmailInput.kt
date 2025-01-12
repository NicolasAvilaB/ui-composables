package com.items.ui.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
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
fun ComposesEmailInput(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    inputValue: MutableState<String>,
    errorInput: Boolean,
    errorMessage: String,
    onValueChange: (String) -> Unit
) {
    val maxLength = 100
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
            text = stringResource(id = R.string.label_email),
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                ComposesText18(
                    text = stringResource(id = R.string.placeholder_your_must_enter_email)
                )
            },
            supportingText = {
                ComposesText16(
                    text = errorMessage
                )
            },
            shape = ShapeDefaults.Medium,
            isError = errorInput,
            value = inputValue.value,
            enabled = enabled,
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription =
                    stringResource(id = R.string.input_email_screen)
                )
            },
            keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewEmailInputLight() {
    val inputValue = remember { mutableStateOf("") }
    val errorInput = false
    val errorMessage = ""
    UicomposablesTheme {
        Surface {
            ComposesEmailInput(
                inputValue = inputValue,
                errorInput = errorInput,
                errorMessage = errorMessage,
                onValueChange = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewEmailInputDark() {
    val inputValue = remember { mutableStateOf("") }
    val errorInput = false
    val errorMessage = ""
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesEmailInput(
                inputValue = inputValue,
                errorInput = errorInput,
                errorMessage = errorMessage,
                onValueChange = { }
            )
        }
    }
}

private val TitlePaddingTextAround = 8.dp
