package com.items.ui.scanqr.analyzer

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class BarcodeAnalyzer(
    private val context: Context,
    private val onQrResult: (String) -> Unit,
    private val singleScan: Boolean,
) : ImageAnalysis.Analyzer {

    private val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
        .build()

    private val scanner = BarcodeScanning.getClient(options)
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
                ).addOnSuccessListener { barcode ->
                    barcode?.takeIf { it.isNotEmpty() }
                        ?.mapNotNull { it.rawValue }
                        ?.joinToString(",")
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