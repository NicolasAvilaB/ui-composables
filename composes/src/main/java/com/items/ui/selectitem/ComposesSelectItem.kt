package com.items.ui.selectitem

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText18

@Composable
fun ComposesSelectItem(
    text: String,
    @DrawableRes icon: Int? = null,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick,
            )
            .indication(
                indication = rememberRipple(bounded = true),
                interactionSource = interactionSource
            )
            .padding(PaddingMenuItem)
            .fillMaxWidth()
    ) {
        icon?.let { drawIcon ->
            painterResource(id = drawIcon)
        }?.let { drawPainter ->
            Image(
                modifier = Modifier.padding(end = ImageEndPaddingItem),
                painter = drawPainter,
                contentDescription = ""
            )
        }

        ComposesText18(
            text = text,
            fontWeight = FontWeight.W400
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectItemLight() {
    UicomposablesTheme {
        Surface {
            ComposesSelectItem(
                text = "Item 1",
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectItemDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesSelectItem(
                text = "Item 1",
                onClick = { }
            )
        }
    }
}

private val PaddingMenuItem = 16.dp
private val ImageEndPaddingItem = 16.dp