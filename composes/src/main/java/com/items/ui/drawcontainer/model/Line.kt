package com.items.ui.drawcontainer.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

data class Line(
    val start: Offset,
    val end: Offset,
    val color: Color,
    val strokeWidth: Dp
)