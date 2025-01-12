package com.items.ui.text

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.items.ui.theme.UicomposablesTheme

@Composable
fun ComposesText18(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontFamily: FontFamily = FontFamily.Default,
    fontWeight: FontWeight = FontWeight.Normal,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    textDecoration: TextDecoration = TextDecoration.None,
    text: String
) {
    Text(
        text = text,
        fontSize = 18.sp,
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

@Preview(showBackground = true)
@Composable
fun PreviewComposesText18Light() {
    UicomposablesTheme {
        Surface {
            ComposesText18(
                text = "Hello World"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposesText18Dark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesText18(
                text = "Hello World"
            )
        }
    }
}