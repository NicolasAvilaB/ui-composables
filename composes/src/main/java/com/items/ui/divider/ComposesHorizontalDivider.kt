package com.items.ui.divider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.theme.UicomposablesTheme

@Composable
fun ComposesHorizontalDivider(){
    HorizontalDivider(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalDividerLight() {
    UicomposablesTheme {
        Surface {
            ComposesHorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalDividerDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesHorizontalDivider()
        }
    }
}