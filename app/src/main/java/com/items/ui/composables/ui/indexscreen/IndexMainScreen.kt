package com.items.ui.composables.ui.indexscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.widget.Group
import com.items.ui.composables.ui.indexscreen.model.listElements
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.selectitem.ComposesSelectItem
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun IndexMainScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = "UI Composables",
                        color = Color.White,
                    )
                },
                color = MaterialTheme.colorScheme.primary
            )
        },
    ) { paddingBar ->
        MainContent(
            paddingBar = paddingBar,
            navGo = navGo
        )
    }
}

@Composable
internal fun MainContent(
    paddingBar: PaddingValues,
    navGo: NavGo,
) {
    val context = LocalContext.current
    val elements = listElements(
        context = context,
        navGo = navGo
    )
    LazyColumn(
        contentPadding = paddingBar
    ) {
        itemsIndexed(elements) { index, element ->
            ComposesSelectItem(
                text = element.label,
                onClick = element.navGoTo
            )
            ComposesHorizontalDivider()
        }
    }
}