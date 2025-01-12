package com.items.ui.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.theme.buttonPrimaryColor40Light
import com.items.ui.theme.buttonPrimaryColor80Dark
import com.items.ui.theme.buttonSelectedColor40Light
import com.items.ui.theme.buttonSelectedColor80Dark
import com.items.ui.theme.isLight
import com.items.ui.composes.R
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ComposesCheckeableSlotButton(
    modifier: Modifier = Modifier,
    countButton: Int,
    disabledButtonIndex: MutableList<Int> = mutableListOf(),
    onSelectedSlot: (Int) -> Unit
) {
    val context = LocalContext.current
    val isLight = MaterialTheme.colorScheme.isLight()
    val isSelected = remember { List(countButton) { mutableStateOf(false) } }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposesText18(
            text = "Slots",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    start = 16.dp
                ),
            fontWeight = FontWeight.W700
        )
        FlowRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            for (i in 0 until countButton) {
                ElevatedButton(
                    modifier = Modifier
                        .height(primaryButtonHeight)
                        .semantics {
                            contentDescription = context.getString(
                                R.string.button_of_select_slot
                            )
                        },
                    onClick = {
                        isSelected.forEachIndexed { index, mutableState ->
                            mutableState.value = index == i
                        }
                        onSelectedSlot(i + 1)
                    },
                    shape = RoundedCornerShape(cornerShapeRadius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = validColorButtonDarkLight(
                            isLight = isLight,
                            index = i,
                            isSelected = isSelected
                        )
                    ),
                    enabled = true && !disabledButtonIndex.contains(i + 1),
                ) {
                    ComposesText16(
                        text = ((i + 1).toString()),
                        fontWeight = FontWeight.W600
                    )
                }
            }
        }
    }
}

private fun validColorButtonDarkLight(
    isLight: Boolean,
    index: Int,
    isSelected: List<MutableState<Boolean>>
) = when {
    isLight ->
        if (isSelected[index].value) buttonSelectedColor40Light
        else buttonPrimaryColor40Light

    else ->
        if (isSelected[index].value) buttonSelectedColor80Dark
        else buttonPrimaryColor80Dark
}

@Preview(showBackground = true)
@Composable
internal fun PreviewButtonScreenLight() {
    UicomposablesTheme {
        Surface {
            ComposesCheckeableSlotButton(
                countButton = 8,
                disabledButtonIndex = mutableListOf(1, 4, 3),
                onSelectedSlot = { }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun PreviewButtonScreenDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ComposesCheckeableSlotButton(
                countButton = 8,
                disabledButtonIndex = mutableListOf(5, 4),
                onSelectedSlot = { }
            )
        }
    }
}

private val primaryButtonHeight = 52.dp
private val cornerShapeRadius = 10.dp
