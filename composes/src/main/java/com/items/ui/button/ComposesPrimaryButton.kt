package com.items.ui.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.composables.ui.theme.buttonPrimaryColor40Light
import com.items.ui.composables.ui.theme.buttonPrimaryColor80Dark
import com.items.ui.composables.ui.theme.isLight
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16

@Composable
fun ComposesPrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    textContent: String
) {
    val isLight = MaterialTheme.colorScheme.isLight()
    ElevatedButton(
        modifier = modifier.height(primaryButtonHeight),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(cornerShapeRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isLight) buttonPrimaryColor40Light
            else buttonPrimaryColor80Dark
        )
    ) {
        ComposesText16(
            text = textContent,
            fontWeight = FontWeight.W600
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButtonLight() {
    UicomposablesTheme {
        Surface {
            ComposesPrimaryButton(
                onClick = {},
                textContent =
                stringResource(id = R.string.button_primary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButtonDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesPrimaryButton(
                onClick = {},
                textContent =
                stringResource(id = R.string.button_primary)
            )
        }
    }
}

private val primaryButtonHeight = 52.dp
private val cornerShapeRadius = 10.dp
