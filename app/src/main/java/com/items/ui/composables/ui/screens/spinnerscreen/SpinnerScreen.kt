package com.items.ui.composables.ui.screens.spinnerscreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composes.R
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.dropdownlist.ComposesDropDownMenu
import com.items.ui.dropdownlist.ComposesFilterDropDownMenu
import com.items.ui.text.ComposesText14
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpinnerScreen(
    navGo: NavGo
) {
    val context = LocalContext.current
    val textValue = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_spinner_screen),
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
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val list = mutableListOf("1","2","3","4")
            val listWords = mutableListOf("Tomato", "Apple", "Oranges", "Bananas", "WaterMelon")
            val inputText = remember { mutableStateOf("") }
            ComposesDropDownMenu(
                title = "Números",
                enabled = true,
                list = list,
                selectedText = inputText,
                itemSelected = {}
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.spinner_default)
            )
            ComposesHorizontalDivider()
            ComposesFilterDropDownMenu(
                modifier = Modifier.padding(top = ComponentPaddingTopDivider),
                title = "Letras",
                textValue = textValue,
                list = listWords,
                onItemSelected = { selectedItem ->
                    Toast.makeText(context, selectedItem, Toast.LENGTH_LONG).show()
                }
            )
            ComposesText14(
                modifier = Modifier.padding(TextPaddingTopDivider),
                text = stringResource(id = R.string.spinner_filter_text)
            )
            ComposesHorizontalDivider()
        }
    }
}

private val ComponentPaddingTopDivider = 36.dp
private val TextPaddingTopDivider = 12.dp
