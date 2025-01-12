package com.items.ui.errortemplate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.text.ComposesText18
import com.items.ui.text.ComposesText20

@Composable
fun ComposesErrorTemplate(
    modifier: Modifier = Modifier,
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
                text = stringResource(id = R.string.error_happen),
                fontWeight =  FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(HeaderTitleTextErrorInTemplate),
            )
            ComposesText18(
                text = stringResource(id = R.string.error_message),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(SubtitleTextErrorInTemplate),
            )
            ComposesPrimaryButton(
                modifier = Modifier.width(ButtonWidthTemplate),
                onClick = onClick,
                textContent = stringResource(id = R.string.retry)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewDrawScreenLight() {
    UicomposablesTheme {
        Surface {
            ComposesErrorTemplate(
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewDrawScreenDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesErrorTemplate(
                onClick = {}
            )
        }
    }
}

private val HeaderTitleTextErrorInTemplate = 24.dp
private val SubtitleTextErrorInTemplate = 24.dp
private val ButtonWidthTemplate = 150.dp
