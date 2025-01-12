package com.items.ui.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.composes.R

@Composable
fun ComposesButtonArrowBack(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val context = LocalContext.current
    IconButton(
        modifier = modifier.semantics {
            contentDescription = context.getString(
                R.string.button_of_back
            )
        },
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "",
            tint = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArrowBackButtonLight() {
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