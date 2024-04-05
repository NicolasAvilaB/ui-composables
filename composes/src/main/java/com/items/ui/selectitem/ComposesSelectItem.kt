package com.items.ui.selectitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.text.ComposesText18

@Composable
fun ComposesSelectItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(paddingRow)
            .fillMaxWidth()
    ) {
        ComposesText18(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight.W400
        )
    }
}

private val paddingRow = 16.dp