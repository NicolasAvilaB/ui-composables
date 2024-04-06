package com.items.ui.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.items.ui.composables.ui.theme.UicomposablesTheme

@Composable
fun ComposesButtonArrowBack(
    onClick: () -> Unit,
    color: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = contentDescription,
            tint = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonArrowBackLight() {
    UicomposablesTheme {
        Surface {
            ComposesButtonArrowBack(
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonArrowBackDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesButtonArrowBack(
                onClick = {}
            )
        }
    }
}