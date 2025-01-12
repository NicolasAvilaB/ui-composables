package com.items.ui.selectitemrow.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun ButtonActionAdd(
    onClick: () -> Unit,
    contentDescription: String = ""
) {
    IconButton(
        modifier = Modifier
            .width(34.dp)
            .height(34.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            imageVector = Icons.Filled.Add,
            contentDescription = contentDescription,
        )
    }
}