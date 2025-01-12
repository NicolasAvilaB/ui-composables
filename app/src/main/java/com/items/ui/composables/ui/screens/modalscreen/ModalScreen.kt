package com.items.ui.composables.ui.screens.modalscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composes.R
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.modal.ComposesModalOnePrimaryButton
import com.items.ui.modal.ComposesModalOneSecondaryButton
import com.items.ui.modal.ComposesModalSearchListButtons
import com.items.ui.modal.ComposesModalTwoHorizontalButtons
import com.items.ui.modal.ComposesModalTwoVerticalButtons
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ModalScreen(
    navGo: NavGo
) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_button_screen),
                    )
                },
                navigationButton = {
                    ComposesButtonArrowBack(
                        onClick = { navGo.popBackStack.invoke() },
                    )
                }
            )
        },
    ) { paddingValues ->
        ModalContent(
            paddingValues = paddingValues
        )
    }

}

@Composable
private fun ModalContent(
    paddingValues: PaddingValues
) {
    val showModalTwoVerticalButtons = remember { mutableStateOf(false) }
    val showModalTwoHorizontalButtons = remember { mutableStateOf(false) }
    val showModalOnePrimaryButton = remember { mutableStateOf(false) }
    val showModalOneSecondaryButtons = remember { mutableStateOf(false) }
    val showModalSearchListButtons = remember { mutableStateOf(false) }
    val searchInputTextValue = remember { mutableStateOf("") }
    val listWords = mutableListOf("Tomato", "Apple", "Oranges", "Bananas", "WaterMelon")

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ComposesPrimaryButton(
            modifier = Modifier
                .padding(
                    top = ButtonPaddingTop,
                    start = ButtonPaddingStartEnd,
                    end = ButtonPaddingStartEnd,
                    bottom = ButtonPaddingBottom
                )
                .fillMaxWidth(),
            textContent = stringResource(id = R.string.label_button_show_alert_dialog),
            onClick = { showModalTwoVerticalButtons.value = true }
        )
        ComposesText14(
            modifier = Modifier
                .padding(TextPaddingAroundDivider),
            text = stringResource(id = R.string.dialog_default_with_two_vertical_buttons)
        )
        ComposesHorizontalDivider()
        ComposesPrimaryButton(
            modifier = Modifier
                .padding(
                    top = ButtonPaddingTop,
                    start = ButtonPaddingStartEnd,
                    end = ButtonPaddingStartEnd,
                    bottom = ButtonPaddingBottom
                )
                .fillMaxWidth(),
            textContent = stringResource(id = R.string.label_button_show_alert_dialog),
            onClick = { showModalTwoHorizontalButtons.value = true }
        )
        ComposesText14(
            modifier = Modifier
                .padding(TextPaddingAroundDivider),
            text = stringResource(id = R.string.dialog_default_with_two_horizontal_buttons)
        )
        ComposesHorizontalDivider()
        ComposesPrimaryButton(
            modifier = Modifier
                .padding(
                    top = ButtonPaddingTop,
                    start = ButtonPaddingStartEnd,
                    end = ButtonPaddingStartEnd,
                    bottom = ButtonPaddingBottom
                )
                .fillMaxWidth(),
            textContent = stringResource(id = R.string.label_button_show_alert_dialog),
            onClick = { showModalOnePrimaryButton.value = true }
        )
        ComposesText14(
            modifier = Modifier
                .padding(TextPaddingAroundDivider),
            text = stringResource(id = R.string.dialog_default_with_primary_button)
        )
        ComposesHorizontalDivider()
        ComposesPrimaryButton(
            modifier = Modifier
                .padding(
                    top = ButtonPaddingTop,
                    start = ButtonPaddingStartEnd,
                    end = ButtonPaddingStartEnd,
                    bottom = ButtonPaddingBottom
                )
                .fillMaxWidth(),
            textContent = stringResource(id = R.string.label_button_show_alert_dialog),
            onClick = { showModalOneSecondaryButtons.value = true }
        )
        ComposesText14(
            modifier = Modifier
                .padding(TextPaddingAroundDivider),
            text = stringResource(id = R.string.dialog_default_with_secondary_button)
        )
        ComposesHorizontalDivider()
        ComposesPrimaryButton(
            modifier = Modifier
                .padding(
                    top = ButtonPaddingTop,
                    start = ButtonPaddingStartEnd,
                    end = ButtonPaddingStartEnd,
                    bottom = ButtonPaddingBottom
                )
                .fillMaxWidth(),
            textContent = stringResource(id = R.string.label_button_show_alert_dialog),
            onClick = { showModalSearchListButtons.value = true }
        )
        ComposesText14(
            modifier = Modifier.padding(TextPaddingAroundDivider),
            text = stringResource(id = R.string.dialog_default_with_list_search_buttons)
        )
        ComposesHorizontalDivider()
    }
    ComposesModalTwoVerticalButtons(
        showModal = showModalTwoVerticalButtons,
        title = stringResource(id = R.string.label_title_modal),
        description = stringResource(id = R.string.lorem_ipsum),
        confirmTextButton = stringResource(id = R.string.accept),
        cancelTextButton = stringResource(id = R.string.cancel),
        onClickConfirm = { showModalTwoVerticalButtons.value = false },
        onClickCancel = { showModalTwoVerticalButtons.value = false }
    )
    ComposesModalTwoHorizontalButtons(
        showModal = showModalTwoHorizontalButtons,
        title = stringResource(id = R.string.label_title_modal),
        description = stringResource(id = R.string.lorem_ipsum),
        confirmTextButton = stringResource(id = R.string.accept),
        cancelTextButton = stringResource(id = R.string.cancel),
        onClickConfirm = { showModalTwoHorizontalButtons.value = false },
        onClickCancel = { showModalTwoHorizontalButtons.value = false }
    )
    ComposesModalOnePrimaryButton(
        showModal = showModalOnePrimaryButton,
        title = stringResource(id = R.string.label_title_modal),
        description = stringResource(id = R.string.lorem_ipsum),
        textButton = stringResource(id = R.string.accept),
        onClickConfirm = { showModalOnePrimaryButton.value = false },
    )
    ComposesModalOneSecondaryButton(
        showModal = showModalOneSecondaryButtons,
        title = stringResource(id = R.string.label_title_modal),
        description = stringResource(id = R.string.lorem_ipsum),
        textButton = stringResource(id = R.string.cancel),
        onClickConfirm = { showModalOneSecondaryButtons.value = false },
    )
    ComposesModalSearchListButtons(
        showModal = showModalSearchListButtons,
        title = stringResource(id = R.string.label_title_list_modal),
        list = listWords,
        searchTitleText = stringResource(id = R.string.write_order),
        searchInputTextValue = searchInputTextValue,
        searchTextButton = stringResource(id = R.string.accept),
        confirmTextButton = stringResource(id = R.string.create_new_order),
        onItemSelected = { },
        onClickSearch = { },
        onClickConfirm = { }
    )
}

@Preview(showBackground = true)
@Composable
fun ModalScreenLight() {
    val context = LocalContext.current
    val navHostController = NavHostController(context)
    val navGo = NavGo(navHostController)
    UicomposablesTheme {
        Surface {
            ModalScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModalScreenDark() {
    val context = LocalContext.current
    val navHostController = NavHostController(context)
    val navGo = NavGo(navHostController)
    UicomposablesTheme(darkTheme = true) {
        Surface {
            ModalScreen(
                navGo = navGo
            )
        }
    }
}

private val TextPaddingAroundDivider = 12.dp
private val ButtonPaddingStartEnd = 20.dp
private val ButtonPaddingTop = 45.dp
private val ButtonPaddingBottom = 15.dp
