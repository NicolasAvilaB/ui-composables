package com.items.ui.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18

@Composable
fun ComposesNumericPasswordInput(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    passValue: MutableState<String>,
    errorInput: Boolean,
    errorMessage: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
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
            text = stringResource(id = R.string.label_pass),
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            placeholder = {
                ComposesText18(
                    text = stringResource(id = R.string.placeholder_your_must_enter_pass_number)
                )
            },
            supportingText = {
                ComposesText16(
                    text = errorMessage
                )
            },
            shape = ShapeDefaults.Medium,
            value = passValue.value,
            singleLine = true,
            maxLines = 1,
            isError = errorInput,
            keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription =
                    stringResource(id = R.string.icon_pass_screen)
                )
            },
            trailingIcon = {
                val imagen =
                    if (passwordVisibility) {
                        Icons.Filled.VisibilityOff
                    } else {
                        Icons.Filled.Visibility
                    }
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    Icon(
                        imageVector = imagen,
                        contentDescription =
                        stringResource(id = R.string.icon_for_watch_pass_screen)
                    )
                }
            },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewPassNumericInputLight() {
    val passValue = remember { mutableStateOf("") }
    val errorInput = false
    val errorMessage = ""
    UicomposablesTheme {
        Surface {
            ComposesNumericPasswordInput(
                passValue = passValue,
                errorInput = errorInput,
                errorMessage = errorMessage,
                onValueChange = { }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun PreviewPassNumericInputDark() {
    val passValue = remember { mutableStateOf("") }
    val errorInput = false
    val errorMessage = ""
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesNumericPasswordInput(
                passValue = passValue,
                errorInput = errorInput,
                errorMessage = errorMessage,
                onValueChange = { }
            )
        }
    }
}

private val TitlePaddingTextAround = 8.dp
