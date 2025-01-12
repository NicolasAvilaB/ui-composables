package com.items.ui.scanqr

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import com.items.ui.scanqr.analyzer.AnalyzerType
import com.items.ui.scanqr.ui.CameraScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.items.ui.composes.R

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ComposesScanQr(
    onQrResult: (String) -> Unit,
    analyzerType: AnalyzerType,
    singleScan: Boolean,
    enabledResult: Boolean = true
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
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCamPermission = granted
        }
    )
    LaunchedEffect(key1 = true) {
        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
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
                singleScan = singleScan,
                enabledResult = enabledResult
            )
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (cameraPermissionState.status.shouldShowRationale) {
                        Text(stringResource(id = R.string.not_have_permission_for_use_cam))
                    } else {
                        Text(stringResource(id = R.string.permission_cam_denied))
                        Toast.makeText(
                            context,
                            R.string.for_scan_qr_must_enabled_the_permissions_to_camera,
                            Toast.LENGTH_LONG
                        ).show()
                        LaunchedEffect(Unit) {
                            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            val uri = Uri.fromParts("package", context.packageName, null)
                            intent.data = uri
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            context.startActivity(intent)
                        }
                    }
                    LaunchedEffect(Unit) {
                        cameraPermissionState.run { launchPermissionRequest() }
                        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                }
            }
        }
    }
}
