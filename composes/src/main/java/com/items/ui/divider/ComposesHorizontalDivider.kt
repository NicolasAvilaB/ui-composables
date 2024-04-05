package com.items.ui.divider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComposesHorizontalDivider(){
    HorizontalDivider(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp
        )
    )
}