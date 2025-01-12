package com.items.ui.selectitemrow

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18

@Composable
fun ComposesDescriptionItem(
    text: String,
    @DrawableRes icon: Int? = null,
    onClick: () -> Unit,
    subText1: String,
    subText2: String,
    subText3: String
) {
    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick,
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
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            ComposesText18(
                text = text,
                fontWeight = FontWeight.W400
            )
            Column(
                modifier = Modifier.padding(start = StartPaddingSubItem)
            ) {
                ComposesText16(
                    text = subText1,
                    fontWeight = FontWeight.W400
                )
                ComposesText16(
                    text = subText2,
                    fontWeight = FontWeight.W400
                )
                ComposesText16(
                    text = subText3,
                    fontWeight = FontWeight.W400
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDescriptionItemLight() {
    UicomposablesTheme {
        Surface {
            ComposesDescriptionItem(
                text = "Item 1",
                onClick = { },
                subText1 = "SubItem 1",
                subText2 = "SubItem 2",
                subText3 = "SubItem 3"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDescriptionItemDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesDescriptionItem(
                text = "Item 1",
                onClick = { },
                subText1 = "SubItem 1",
                subText2 = "SubItem 2",
                subText3 = "SubItem 3"
            )
        }
    }
}

private val StartPaddingSubItem = 18.dp
private val PaddingMenuItem = 16.dp
private val ImageEndPaddingItem = 16.dp
