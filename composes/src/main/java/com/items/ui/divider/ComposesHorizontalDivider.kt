package com.items.ui.divider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.theme.colorDividerDark
import com.items.ui.theme.colorDividerLight
import com.items.ui.theme.isLight

@Composable
fun ComposesHorizontalDivider(
    modifier: Modifier = Modifier
){
    val isLight = MaterialTheme.colorScheme.isLight()

    HorizontalDivider(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp
        ),
        color = if (isLight) colorDividerDark
        else colorDividerLight

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