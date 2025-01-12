package com.items.ui.composables.ui.screens.mainscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.drivin.android.ui.screens.mainscreen.model.ListElements
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.selectitemrow.ComposesMenuItem
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.title),
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            navGo.settingScreen.invoke()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
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
    val elements = ListElements(
        context = context,
        navGo = navGo
    )
    LazyColumn(
        contentPadding = paddingBar
    ) {
        itemsIndexed(elements) { index, element ->
            ComposesMenuItem(
                text = element.label,
                onClick = element.navGoTo
            )
            ComposesHorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewIndexMainScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            MainScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewIndexMainScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(darkTheme = true) {
        Surface {
            MainScreen(
                navGo = navGo
            )
        }
    }
}