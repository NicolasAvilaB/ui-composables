package com.items.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.composables.ui.theme.buttonNavigationColor40Light
import com.items.ui.composables.ui.theme.buttonNavigationColor80Dark
import com.items.ui.composables.ui.theme.buttonNavigationDisabled40Light
import com.items.ui.composables.ui.theme.buttonNavigationDisabled80Dark
import com.items.ui.composables.ui.theme.isLight
import com.items.ui.text.ComposesText16

@Composable
fun ComposesNavigationButton(
    textContent: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val isLight = MaterialTheme.colorScheme.isLight()
    Row(modifier = Modifier
        .clickable(enabled = enabled) { onClick() }
        .padding(start = ButtonPaddingNavigationRow,
            bottom = ButtonPaddingNavigationRow,
            top = ButtonPaddingNavigationRow
        )
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(ButtonCornerShapeNavigationRow))
                .background(
                    when {
                        enabled -> {
                            if (isLight) buttonNavigationColor40Light
                            else buttonNavigationColor80Dark
                        }

                        else -> {
                            if (isLight) buttonNavigationDisabled40Light
                            else buttonNavigationDisabled80Dark
                        }
                    }
                )
                .padding(ButtonPaddingWithBackground)
        ) {
            ComposesText16(
                text = textContent,
                fontWeight = FontWeight.W600,
                color =
                if (enabled)
                    MaterialTheme.colorScheme.onPrimary
                else
                    if (isLight) buttonNavigationDisabled80Dark
                    else buttonNavigationDisabled40Light
            )
        }
        Icon(
            modifier = Modifier
                .size(ButtonSizeNavigationRow)
                .padding(ButtonPaddingNavigationRow),
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            tint =
            when {
                enabled -> {
                    MaterialTheme.colorScheme.primary
                }

                else -> {
                    if (isLight) buttonNavigationDisabled80Dark
                    else buttonNavigationDisabled40Light
                }
            },
            contentDescription = "",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationButtonLight() {
    UicomposablesTheme {
        Surface {
            ComposesNavigationButton(
                textContent = "Continuar",
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationButtonDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesNavigationButton(
                textContent = "Continuar",
                onClick = { }
            )
        }
    }
}

private val ButtonPaddingWithBackground = 15.dp
private val ButtonSizeNavigationRow = 55.dp
private val ButtonCornerShapeNavigationRow = 10.dp
private val ButtonPaddingNavigationRow = 10.dp
