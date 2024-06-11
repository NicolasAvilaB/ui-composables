package com.items.ui.scanqr

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.scanqr.model.AnalyzerType
import com.items.ui.scanqr.ui.CameraScreen

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ComposesScanQr(
    onQrResult: (String) -> Unit,
    analyzerType: AnalyzerType,
    singleScan: Boolean
) {
    val context = LocalContext.current
    var hasCamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCamPermission = granted
        }
    )
    LaunchedEffect(key1 = true) {
        launcher.launch(Manifest.permission.CAMERA)
    }
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    var analyzerType by remember { mutableStateOf(analyzerType) }

    when {
        analyzerType == AnalyzerType.UNDEFINED -> {
            Toast.makeText(context, R.string.message_type_scan, Toast.LENGTH_LONG).show()
        }

        hasCamPermission -> {
            CameraScreen(
                analyzerType = analyzerType,
                onQrResult = { result ->
                    onQrResult(result)
                },
                singleScan = singleScan
            )
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (cameraPermissionState.status.shouldShowRationale) {
                        Text(
                            stringResource(id = R.string.permission_cam_denied)
                        )
                    } else {
                        SideEffect {
                            cameraPermissionState.run { launchPermissionRequest() }
                        }
                        Text(stringResource(id = R.string.not_have_permission_for_use_cam))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScanQrLight() {
    UicomposablesTheme {
        Surface {
            ComposesScanQr(
                onQrResult = { },
                analyzerType = AnalyzerType.BARCODE,
                singleScan = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScanQrDark() {
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            ComposesScanQr(
                onQrResult = { },
                analyzerType = AnalyzerType.BARCODE,
                singleScan = true
            )
        }
    }
}