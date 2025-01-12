package com.items.ui.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.theme.backgroundModalDark
import com.items.ui.theme.backgroundModalLight
import com.items.ui.theme.isLight
import com.items.ui.composes.R
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.text.ComposesText18
import com.items.ui.text.ComposesText20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposesModalOnePrimaryButton(
    modifier: Modifier = Modifier,
    showModal: MutableState<Boolean>,
    title: String,
    textAlign: TextAlign? = null,
    description: String,
    textButton: String,
    onClickConfirm: () -> Unit,
) {
    val isLight = MaterialTheme.colorScheme.isLight()

    if (showModal.value) {
        BasicAlertDialog(
            onDismissRequest = {
                showModal.value = false
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Column(
                modifier = modifier
                    .background(
                        if (isLight) backgroundModalLight
                        else backgroundModalDark,
                        RoundedCornerShape(ColumnRoundedCornerShape)
                    )
                    .fillMaxWidth()
                    .padding(ColumnPaddingAround),
                horizontalAlignment = Alignment.Start
            ) {
                ComposesText20(
                    modifier = Modifier.padding(
                        bottom = TitlePaddingTextBottom
                    ),
                    fontWeight = FontWeight.W600,
                    text = title
                )
                ComposesHorizontalDivider()
                ComposesText18(
                    modifier = Modifier.padding(
                        top = TextDescriptionPaddingTopBottom,
                        bottom = TextDescriptionPaddingTopBottom
                    ),
                    textAlign = textAlign,
                    text = description
                )
                ComposesPrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    textContent = textButton,
                    onClick = { onClickConfirm() }
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun PreviewModalPrimaryOneButtonsLight() {
    UicomposablesTheme {
        Surface {
            val showModal = remember { mutableStateOf(true) }
            ComposesModalOnePrimaryButton(
                showModal = showModal,
                title = "Information",
                description = stringResource(id = R.string.lorem_ipsum),
                textButton = "Aceptar",
                onClickConfirm = { }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun PreviewModalPrimaryOneButtonsDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            val showModal = remember { mutableStateOf(true) }
            ComposesModalOnePrimaryButton(
                showModal = showModal,
                title = "Information",
                description = stringResource(id = R.string.lorem_ipsum),
                textButton = "Aceptar",
                onClickConfirm = { }
            )
        }
    }
}

private val TitlePaddingTextBottom = 20.dp
private val ColumnRoundedCornerShape = 16.dp
private val ColumnPaddingAround = 26.dp
private val TextDescriptionPaddingTopBottom = 24.dp
