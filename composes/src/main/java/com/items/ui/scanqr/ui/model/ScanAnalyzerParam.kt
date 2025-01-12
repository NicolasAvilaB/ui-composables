package com.items.ui.scanqr.ui.model

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture

internal data class ScanAnalyzerParam(
    val cameraViewVisible: MutableState<Boolean>,
    val cameraProviderFuture: ListenableFuture<ProcessCameraProvider>,
    val lifecycleOwner: LifecycleOwner,
    val selector: CameraSelector,
    val preview: Preview,
    val imageAnalysis: ImageAnalysis
)
