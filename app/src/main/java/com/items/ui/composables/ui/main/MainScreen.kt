package com.items.ui.composables.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.items.ui.composables.ui.main.model.listElements
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.selectitem.ComposesSelectItem

@Composable
internal fun MainScreen(navGo: NavGo) {
    Surface{
        MainContent(
            navGo = navGo
        )
    }
}

@Composable
internal fun MainContent(
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