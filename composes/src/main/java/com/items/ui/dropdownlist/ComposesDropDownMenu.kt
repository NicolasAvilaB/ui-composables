package com.items.ui.dropdownlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.ItemContentPadding
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposesDropDownMenu(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    title: String,
    list: MutableList<String>,
    selectedText: MutableState<String>,
    itemSelected: (String) -> Unit
) {
    val isExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ComposesText16(
            modifier = Modifier.padding(TitlePaddingTextAround),
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
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                enabled = enabled,
                placeholder = {
                    Text(text = stringResource(id = R.string.select_option))
                },
                value = selectedText.value,
                onValueChange = { resultValue ->
                    selectedText.value = resultValue
                },
                readOnly = true,
                trailingIcon = {
                    TrailingIcon(expanded = isExpanded.value)
                }
            )
            ExposedDropdownMenu(
                expanded = isExpanded.value,
                onDismissRequest = { if (enabled) isExpanded.value = false },
            ) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        enabled = enabled,
                        text = {
                            Text(text = text)
                        }, onClick = {
                            selectedText.value = list[index]
                            itemSelected(list[index])
                            isExpanded.value = false
                        },
                        contentPadding = ItemContentPadding
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewDropDownLight() {
    val list = mutableListOf("One", "Two", "Three", "Four")
    val inputText = remember { mutableStateOf("") }
    UicomposablesTheme {
        Surface {
            ComposesDropDownMenu(
                title = "Números",
                list = list,
                selectedText = inputText,
                itemSelected = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewDropDownDark() {
    val list = mutableListOf("One", "Two", "Three", "Four")
    val inputText = remember { mutableStateOf("") }
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesDropDownMenu(
                title = "Números",
                list = list,
                selectedText = inputText,
                itemSelected = {}
            )
        }
    }
}

private val TitlePaddingTextAround = 8.dp
