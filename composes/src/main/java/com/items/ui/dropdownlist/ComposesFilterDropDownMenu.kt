package com.items.ui.dropdownlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposesFilterDropDownMenu(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    title: String,
    list: MutableList<String>,
    textValue: MutableState<String>,
    onItemSelected: (String) -> Unit
) {
    val isExpanded = remember { mutableStateOf(false) }
    val filteredList = list.filter { it.contains(textValue.value, ignoreCase = true) }

    Column(
        modifier = modifier.fillMaxWidth()
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
        ExposedDropdownMenuBox(
            expanded = isExpanded.value,
            onExpandedChange = {
                if (enabled) {
                    isExpanded.value = !isExpanded.value
                }
            }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                enabled = enabled,
                placeholder = {
                    Text(text = stringResource(id = R.string.search_option_and_select))
                },
                value = textValue.value,
                onValueChange = { changeValue ->
                    textValue.value = changeValue
                    isExpanded.value = changeValue.isNotEmpty() || filteredList.isNotEmpty()
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded.value)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )
            ExposedDropdownMenu(
                expanded = isExpanded.value,
                onDismissRequest = { if (enabled) isExpanded.value = false },
            ) {
                filteredList.forEach { text ->
                    DropdownMenuItem(
                        text = {
                            Text(text = text)
                        }, onClick = {
                            textValue.value = text
                            isExpanded.value = false
                            onItemSelected(text)
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewFilterDropDownLight() {
    val list = mutableListOf("One", "Two", "Three", "Four")
    val inputText = remember { mutableStateOf("") }
    UicomposablesTheme {
        Surface {
            ComposesFilterDropDownMenu(
                title = "Números",
                list = list,
                textValue = inputText,
                onItemSelected = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewFilterDropDownDark() {
    val list = mutableListOf("One", "Two", "Three", "Four")
    val inputText = remember { mutableStateOf("") }
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesFilterDropDownMenu(
                title = "Números",
                list = list,
                textValue = inputText,
                onItemSelected = { }
            )
        }
    }
}

private val TitlePaddingTextAround = 8.dp
