package com.items.ui.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposesTopAppBar(
    title: @Composable () -> Unit = {},
    navigationButton: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    color: Color = Color.Black,
    titleColor: Color = Color.White,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = title,
        windowInsets =  windowInsets,
        navigationIcon = navigationButton,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color,
            titleContentColor = titleColor,
        ),
        scrollBehavior = scrollBehavior,
        modifier = Modifier.statusBarsPadding().navigationBarsPadding()
    )
}