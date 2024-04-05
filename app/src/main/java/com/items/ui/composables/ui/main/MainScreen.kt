package com.items.ui.composables.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.items.ui.composables.ui.model.listElements
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.selectitem.ComposesSelectItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            Text(text = "Principal Screen")
        }
    ) { paddingValue ->
        MainContent(
            paddingValues = paddingValue,
            navGo = navGo
        )
    }
}

@Composable
fun MainContent(
    paddingValues: PaddingValues,
    navGo: NavGo
) {
    val context = LocalContext.current
    val elements = listElements(
        context = context,
        navGo = navGo
    )
    LazyColumn {
        itemsIndexed(elements) { index, element ->
            ComposesSelectItem(
                text = element.label,
                onClick = element.navGoTo
            )
        }
    }
}