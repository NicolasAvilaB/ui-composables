package com.items.ui.switc

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText18

@Composable
fun ComposesSwitch(
    text: String,
    checked: Boolean,
    enabled: Boolean = true,
    onStateChange: (Boolean) -> Unit,
    thumbContent: (@Composable () -> Unit)? = null,
){
    Row(
        modifier = Modifier
            .clickable(enabled = enabled, role = Role.Switch,
                onClick = {
                    onStateChange(!checked)
                }
            )
            .padding(PaddingContainerSwitchWithText).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComposesText18(
            modifier = Modifier
                .weight(1f)
                .padding(start = PaddingCornerSwitchWithText),
            text = text
        )
        Switch(
            modifier = Modifier
                .padding(end = PaddingCornerSwitchWithText),
            checked = checked,
            thumbContent = thumbContent,
            onCheckedChange = { result ->
                onStateChange(result)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSwitchScreenLight() {
    val onChange = remember { mutableStateOf(true) }
    UicomposablesTheme {
        Surface {
            ComposesSwitch(
                text = "Text",
                checked = onChange.value,
                onStateChange = { onChange.value = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSwitchScreenDark() {
    val onChange = remember { mutableStateOf(true) }
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesSwitch(
                text = "Text",
                checked = onChange.value,
                onStateChange = { onChange.value = it }
            )
        }
    }
}

private val PaddingCornerSwitchWithText = 10.dp
private val PaddingContainerSwitchWithText = 8.dp