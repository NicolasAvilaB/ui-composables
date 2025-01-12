package com.items.ui.scanqr.ui

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import com.items.ui.scanqr.analyzer.AnalyzerType
import com.items.ui.scanqr.ui.model.ScanAnalyzerParam
import com.items.ui.scanqr.ui.model.ScanAnalyzerProvider

@Composable
fun CameraScreen(
    analyzerType: AnalyzerType,
    onQrResult: (String) -> Unit,
    singleScan: Boolean,
    enabledResult: Boolean
) {
    val localContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(localContext)
    }

    val cameraViewVisible = remember { mutableStateOf(true) }

    if (cameraViewVisible.value) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                val previewView = PreviewView(context)
                cameraProviderFuture.get().unbindAll()
                val preview = Preview.Builder().build()
                val selector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                val imageAnalysis = ImageAnalysis.Builder().build()

                val scanAnalyzerProvider = ScanAnalyzerProvider(
                    context = context,
                    analyzerType = analyzerType,
                    onQrResult = onQrResult,
                    singleScan = singleScan,
                    enabledResult = enabledResult,
                    params = ScanAnalyzerParam(
                        cameraViewVisible = cameraViewVisible,
                        cameraProviderFuture = cameraProviderFuture,
                        lifecycleOwner = lifecycleOwner,
                        selector = selector,
                        preview = preview,
                        imageAnalysis = imageAnalysis
                    ),
                )

                preview.setSurfaceProvider(previewView.surfaceProvider)
                scanAnalyzerProvider.startAnalyzerCamera()
                previewView
            }
        )
    }
}
