package com.items.ui.scanqr.analyzer

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class TextAnalyzer(
    private val context: Context,
    private val onQrResult: (String) -> Unit,
    private val singleScan: Boolean
) : ImageAnalysis.Analyzer {

    private val options = TextRecognizerOptions.DEFAULT_OPTIONS

    private val scanner = TextRecognition.getClient(options)
    private var hasScanned = false

    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        if (hasScanned && singleScan) {
            imageProxy.close()
            return
        }
        imageProxy.image
            ?.let { image ->
                scanner.process(
                    InputImage.fromMediaImage(
                        image, imageProxy.imageInfo.rotationDegrees
                    )
                ).addOnSuccessListener { results ->
                    results.textBlocks
                        .takeIf { it.isNotEmpty() }
                        ?.joinToString(",") { it.text }
                        ?.let { code ->
                            Toast.makeText(context, "Result: $code", Toast.LENGTH_LONG).show()
                            onQrResult(code)
                            if (singleScan) {
                                hasScanned = true
                            }
                        }
                }.addOnCompleteListener {
                    imageProxy.close()
                }
            }
    }
}