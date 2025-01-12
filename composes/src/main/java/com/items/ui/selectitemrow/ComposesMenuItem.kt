package com.items.ui.selectitemrow

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.selectitemrow.components.ButtonActionAdd
import com.items.ui.selectitemrow.components.ButtonActionDelete
import com.items.ui.selectitemrow.components.ButtonActionEdit
import com.items.ui.selectitemrow.model.MenuItemAction
import com.items.ui.selectitemrow.model.MenuItemAction.Add
import com.items.ui.selectitemrow.model.MenuItemAction.All
import com.items.ui.selectitemrow.model.MenuItemAction.Delete
import com.items.ui.selectitemrow.model.MenuItemAction.Edit
import com.items.ui.selectitemrow.model.MenuItemAction.None
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText18

@Composable
fun ComposesMenuItem(
    text: String,
    @DrawableRes icon: Int? = null,
    enabledActionItem: MenuItemAction = None,
    onClickActionAdd: (() -> Unit)? = null,
    onClickActionEdit: (() -> Unit)? = null,
    onClickActionDelete: (() -> Unit)? = null,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick,
            )
            .padding(PaddingMenuItem)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        icon?.let { drawIcon ->
            painterResource(id = drawIcon)
        }?.let { drawPainter ->
            Image(
                modifier = Modifier
                    .padding(end = ImageEndPaddingItem)
                    .padding(5.dp),
                painter = drawPainter,
                contentDescription = ""
            )
        }
        ComposesText18(
            modifier = Modifier
                .weight(1f)
                .padding(5.dp),
            text = text,
            fontWeight = FontWeight.W400
        )
        when (enabledActionItem) {
            None -> {}
            Add -> {
                ButtonActionAdd(
                    onClick = { onClickActionAdd?.invoke() }
                )
            }

            Edit -> {
                ButtonActionEdit(
                    onClick = { onClickActionEdit?.invoke() }
                )
            }

            Delete -> {
                ButtonActionDelete(
                    onClick = { onClickActionDelete?.invoke() }
                )
            }

            All -> {
                ButtonActionAdd(
                    onClick = { onClickActionAdd?.invoke() }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                ButtonActionEdit(
                    onClick = { onClickActionEdit?.invoke() }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                ButtonActionDelete(
                    onClick = { onClickActionDelete?.invoke() }
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectItemLight() {
    UicomposablesTheme {
        Surface {
            ComposesMenuItem(
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
            ComposesMenuItem(
                text = "Item 1",
                onClick = { }
            )
        }
    }
}

private val PaddingMenuItem = 16.dp
private val ImageEndPaddingItem = 16.dp
