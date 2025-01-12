package com.items.ui.composables.ui.screens.scanqrscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.scanqr.ComposesScanQr
import com.items.ui.scanqr.analyzer.AnalyzerType
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ScanQrTextScreen(navGo: NavGo) {
    var result by remember { mutableStateOf<String?>("") }
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_scanqr_screen),
                    )
                },
                navigationButton = {
                    ComposesButtonArrowBack(
                        onClick = { navGo.popBackStack.invoke() },
                    )
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = "Resultado: $result",
                textAlign = TextAlign.Center
            )
            Column(modifier = Modifier.fillMaxHeight(0.9f)) {
                ComposesScanQr(
                    onQrResult = { onResult ->
                        result = onResult
                    },
                    analyzerType = AnalyzerType.TEXT,
                    singleScan = true
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewScanQrTextScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            ScanQrTextScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewScanQrTextScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ScanQrTextScreen(
                navGo = navGo
            )
        }
    }
}