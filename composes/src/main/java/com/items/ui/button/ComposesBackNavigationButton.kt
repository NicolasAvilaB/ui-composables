package com.items.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.theme.buttonNavigationColor40Light
import com.items.ui.theme.buttonNavigationColor80Dark
import com.items.ui.theme.buttonNavigationDisabled40Light
import com.items.ui.theme.buttonNavigationDisabled80Dark
import com.items.ui.theme.isLight
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16

@Composable
fun ComposesBackNavigationButton(
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val isLight = MaterialTheme.colorScheme.isLight()
    Row(modifier = modifier
        .semantics {
            contentDescription = context.getString(
                R.string.button_of
            )
        }
        .clickable(enabled = enabled) { onClick() }
        .padding(
            end = ButtonPaddingNavigationRow,
            bottom = ButtonPaddingNavigationRow,
            top = ButtonPaddingNavigationRow
        )
    ) {
        Icon(
            modifier = Modifier
                .size(ButtonSizeNavigationRow)
                .padding(ButtonPaddingNavigationRow),
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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
        Box(
            modifier = Modifier
                .width(ButtonWidthNavigationContainter)
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
                .padding(ButtonPaddingWithBackground),
            contentAlignment = Alignment.Center
        ) {
            ComposesText16(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.back),
                fontWeight = FontWeight.W600,
                color =
                if (enabled)
                    MaterialTheme.colorScheme.onPrimary
                else
                    if (isLight) buttonNavigationDisabled80Dark
                    else buttonNavigationDisabled40Light
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBackNavigationButtonLight() {
    UicomposablesTheme {
        Surface {
            ComposesBackNavigationButton(
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBackNavigationButtonDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesBackNavigationButton(
                onClick = { }
            )
        }
    }
}

private val ButtonWidthNavigationContainter = 130.dp
private val ButtonPaddingWithBackground = 15.dp
private val ButtonSizeNavigationRow = 55.dp
private val ButtonCornerShapeNavigationRow = 10.dp
private val ButtonPaddingNavigationRow = 10.dp
