package com.items.ui.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.items.ui.composables.ui.theme.UicomposablesTheme

@Composable
fun ComposesCentralLoading(
    modifier: Modifier = Modifier,
    colorProgress: Color = ProgressIndicatorDefaults.circularColor,
    colorBackground: Color = ProgressIndicatorDefaults.circularTrackColor,
    progressWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    progressCap: StrokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = colorProgress,
            trackColor = colorBackground,
            strokeWidth = progressWidth,
            strokeCap = progressCap
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposesCentralLoadingLight() {
    UicomposablesTheme {
        Surface {
            ComposesCentralLoading()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposesCentralLoadingDark() {
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            ComposesCentralLoading()
        }
    }
}
