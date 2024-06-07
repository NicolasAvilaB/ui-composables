package com.items.ui.drawcontainer

import android.graphics.Bitmap
import android.graphics.Paint
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.button.ComposesSecondaryButton
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.composes.R
import com.items.ui.drawcontainer.model.Line

@Composable
fun ComposesDrawContainer(
    colorDrawLine: Color = Color.Blue,
    colorBackground: Color = Color.LightGray,
    strokeWidth: Dp = 4.dp,
    onBitmapResult: (Bitmap) -> Unit,
    toastMessage: String
) {
    val context = LocalContext.current
    val lines = remember { mutableStateListOf<Line>() }
    var boxWidth by remember { mutableStateOf(0) }
    var boxHeight by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(350.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(colorBackground)
                .onGloballyPositioned { coordinates ->
                    boxWidth = coordinates.size.width
                    boxHeight = coordinates.size.height
                }
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .clipToBounds()
                    .pointerInput(true) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            val line = Line(
                                start = change.position - dragAmount,
                                end = change.position,
                                color = colorDrawLine,
                                strokeWidth = strokeWidth
                            )
                            lines.add(line)
                        }
                    }
            ) {
                lines.forEach { line ->
                    drawLine(
                        color = line.color,
                        start = line.start,
                        end = line.end,
                        strokeWidth = line.strokeWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            ComposesSecondaryButton(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp),
                onClick = {
                    onBitmapResult(deleteBitmap())
                    lines.clear()
                },
                textContent = stringResource(id = R.string.delete)
            )
            ComposesPrimaryButton(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                onClick = {
                    if (lines.isNullOrEmpty()) {
                        Toast.makeText(context, toastMessage, LENGTH_SHORT).show()
                    } else {
                        onBitmapResult(
                            createBitmap(
                                lines = lines,
                                backgroundColor = colorBackground,
                                boxWidth = boxWidth,
                                boxHeight = boxHeight
                            )
                        )
                    }
                },
                textContent = stringResource(id = R.string.save)
            )
        }
    }
}

internal fun createBitmap(
    boxWidth: Int,
    boxHeight: Int,
    lines: List<Line>,
    backgroundColor: Color
): Bitmap {
    val bitmap = Bitmap.createBitmap(boxWidth, boxHeight, Bitmap.Config.ARGB_8888)
    val canvas = android.graphics.Canvas(bitmap)
    canvas.drawColor(backgroundColor.toArgb())
    val paint = Paint().apply {
        isAntiAlias = true
    }
    lines.forEach { line ->
        paint.color = line.color.toArgb()
        paint.strokeWidth = line.strokeWidth.value + 3
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawLine(line.start.x, line.start.y, line.end.x, line.end.y, paint)
    }
    return bitmap
}

internal fun deleteBitmap(): Bitmap {
    val bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
    return bitmap
}

@Preview(showBackground = true)
@Composable
fun PreviewDrawingTouchEventLight() {
    UicomposablesTheme {
        Surface {
            val toastMessage = ""
            val bitMapState = remember { mutableStateOf<Bitmap?>(null) }
            ComposesDrawContainer(
                onBitmapResult = { bitMapState },
                toastMessage = toastMessage
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDrawingTouchEventDark() {
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            val toastMessage = ""
            val bitMapState = remember { mutableStateOf<Bitmap?>(null) }
            ComposesDrawContainer(
                onBitmapResult = { bitMapState },
                toastMessage = toastMessage
            )
        }
    }
}
