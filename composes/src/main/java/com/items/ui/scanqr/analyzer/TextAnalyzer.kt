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
    private val onQrResult: (String) -> Unit
) : ImageAnalysis.Analyzer {

    private val options = TextRecognizerOptions.DEFAULT_OPTIONS

    private val scanner = TextRecognition.getClient(options)

    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
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
                        }
                }.addOnCompleteListener {
                    imageProxy.close()
                }
            }
    }
}