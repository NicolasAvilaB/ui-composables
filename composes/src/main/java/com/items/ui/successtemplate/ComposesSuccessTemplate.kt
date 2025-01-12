package com.items.ui.successtemplate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText18
import com.items.ui.text.ComposesText20

@Composable
fun ComposesSuccessTemplate(
    modifier: Modifier = Modifier,
    textTitle: String,
    textSubtitle: String,
    textButton: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComposesText20(
                text = textTitle,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(HeaderTitleTextErrorInTemplate),
            )
            ComposesText18(
                text = textSubtitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(SubtitleTextErrorInTemplate),
            )
            ComposesPrimaryButton(
                modifier = Modifier.width(ButtonWidthTemplate),
                onClick = onClick,
                textContent = textButton
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSwitchScreenLight() {
    UicomposablesTheme {
        Surface {
            ComposesSuccessTemplate(
                textTitle = "¡Genial!",
                textSubtitle = "La operación se completó con éxito",
                textButton = "Aceptar",
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewSwitchScreenDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesSuccessTemplate(
                textTitle = "¡Genial!",
                textSubtitle = "La operación se completó con éxito",
                textButton = "Aceptar",
                onClick = { }
            )
        }
    }
}

private val HeaderTitleTextErrorInTemplate = 24.dp
private val SubtitleTextErrorInTemplate = 24.dp
private val ButtonWidthTemplate = 200.dp
