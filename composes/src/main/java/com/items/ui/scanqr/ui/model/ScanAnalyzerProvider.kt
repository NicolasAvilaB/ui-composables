package com.items.ui.scanqr.ui.model

import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.core.content.ContextCompat
import com.items.ui.scanqr.analyzer.AnalyzerType
import com.items.ui.scanqr.analyzer.BarcodeAnalyzer
import com.items.ui.scanqr.analyzer.TextAnalyzer

internal class ScanAnalyzerProvider(
    private val context: Context,
    private val analyzerType: AnalyzerType,
    private val onQrResult: (String) -> Unit,
    private val singleScan: Boolean,
    private val enabledResult: Boolean,
    private val params: ScanAnalyzerParam
) {

    internal fun startAnalyzerCamera() {
        params.imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(context),
            if (analyzerType == AnalyzerType.BARCODE) {
                BarcodeAnalyzer(
                    context = context,
                    onQrResult = { result ->
                        onQrResult(result)
                        params.cameraProviderFuture.get().unbindAll()
                        if (singleScan) {
                            params.cameraViewVisible.value = false
                        } else {
                            restartCamera()
                        }
                    },
                    singleScan = singleScan,
                    enabledResult = enabledResult
                )
            } else {
                TextAnalyzer(
                    context = context,
                    onQrResult = { result ->
                        onQrResult(result)
                        params.cameraProviderFuture.get().unbindAll()
                        if (singleScan) {
                            params.cameraViewVisible.value = false
                        } else {
                            restartCamera()
                        }
                    },
                    singleScan = singleScan,
                    enabledResult = enabledResult
                )
            }
        )
        restartCamera()
    }

    internal fun restartCamera() {
        Handler().postDelayed({
            runCatching {
                params.cameraProviderFuture.get().bindToLifecycle(
                    params.lifecycleOwner,
                    params.selector,
                    params.preview,
                    params.imageAnalysis
                )
            }.onFailure { e ->
                Log.e("CAMERA", "Camera bind error ${e.localizedMessage}", e)
            }
        }, 1200)
    }
}
