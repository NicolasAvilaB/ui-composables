package com.items.ui.scanqr.ui

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.items.ui.scanqr.analyzer.BarcodeAnalyzer
import com.items.ui.scanqr.analyzer.TextAnalyzer
import com.items.ui.scanqr.model.AnalyzerType

@Composable
fun CameraScreen(
    analyzerType: AnalyzerType,
    onQrResult: (String) -> Unit,
    singleScan: Boolean
) {
    val localContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(localContext)
    }
    var cameraViewVisible by remember { mutableStateOf(true) }
    if (cameraViewVisible) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                val previewView = PreviewView(context)
                val preview = Preview.Builder().build()
                val selector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                preview.setSurfaceProvider(previewView.surfaceProvider)

                val imageAnalysis = ImageAnalysis.Builder().build()
                imageAnalysis.setAnalyzer(
                    ContextCompat.getMainExecutor(context),
                    if (analyzerType == AnalyzerType.BARCODE) {
                        BarcodeAnalyzer(
                            context = context,
                            onQrResult = { result ->
                                onQrResult(result)
                                if (singleScan) {
                                    cameraProviderFuture.get().unbindAll()
                                    cameraViewVisible = false
                                }
                            },
                            singleScan = singleScan
                        )
                    } else {
                        TextAnalyzer(
                            context = context,
                            onQrResult = { result ->
                                onQrResult(result)
                                if (singleScan) {
                                    cameraProviderFuture.get().unbindAll()
                                    cameraViewVisible = false
                                }
                            },
                            singleScan = singleScan
                        )
                    }
                )

                runCatching {
                    cameraProviderFuture.get().bindToLifecycle(
                        lifecycleOwner,
                        selector,
                        preview,
                        imageAnalysis
                    )
                }.onFailure {
                    Log.e("CAMERA", "Camera bind error ${it.localizedMessage}", it)
                }
                previewView
            }
        )
    }
}