package com.items.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ComposesText16(
    modifier: Modifier = Modifier,
    color: Color,
    fontFamily: FontFamily = FontFamily.Default,
    fontWeight: FontWeight,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    textDecoration: TextDecoration = TextDecoration.None,
    text: String
) {
    Text(
        text = text,
        fontSize = 16.sp,
        textAlign = textAlign,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        lineHeight = lineHeight,
        textDecoration = textDecoration,
        color = color,
        modifier = modifier
    )
}