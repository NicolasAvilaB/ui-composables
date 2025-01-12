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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.input.model.CustomKeyboardTypeText
import com.items.ui.input.model.KeyboardOptionsTypeText
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18

@Composable
fun ComposesOutlinedTextInput(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    title: String,
    textValue: MutableState<String>,
    placeHolder: String,
    keyboardOptionsType: KeyboardOptionsTypeText,
    errorInput: Boolean = false,
    errorMessage: String = "",
    onValueChange: (String) -> Unit,
) {
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
                    text = placeHolder
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
                keyboardType = keyboardOptionsType.getKeyboardType()
            ),
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewOutlinedTextInputLight() {
    val passValue = remember { mutableStateOf("") }
    val maxLength = 100
    val errorInput = false
    val errorMessage = ""
    UicomposablesTheme {
        Surface {
            ComposesOutlinedTextInput(
                title = "Correo",
                textValue = passValue,
                errorInput = errorInput,
                errorMessage = errorMessage,
                placeHolder = "Ingrese correo...",
                keyboardOptionsType = KeyboardOptionsTypeText(CustomKeyboardTypeText.Text),
                onValueChange = { changeValue ->
                    if (changeValue.length <= maxLength) {
                        passValue.value = changeValue
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun PreviewOutlinedTextInputDark() {
    val passValue = remember { mutableStateOf("") }
    val maxLength = 100
    val errorInput = false
    val errorMessage = ""
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesOutlinedTextInput(
                title = "Correo",
                textValue = passValue,
                errorInput = errorInput,
                errorMessage = errorMessage,
                placeHolder = "Ingrese correo...",
                keyboardOptionsType = KeyboardOptionsTypeText(CustomKeyboardTypeText.Text),
                onValueChange = { changeValue ->
                    if (changeValue.length <= maxLength) {
                        passValue.value = changeValue
                    }
                }
            )
        }
    }
}

private val TitlePaddingTextAround = 8.dp
