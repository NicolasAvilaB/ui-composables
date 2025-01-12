package com.items.ui.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.text.ComposesText20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposesCenterAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit = {},
    navigationButton: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    color: Color = MaterialTheme.colorScheme.primary,
    titleColor: Color = MaterialTheme.colorScheme.onPrimary,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        title = title,
        windowInsets =  windowInsets,
        navigationIcon = navigationButton,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color,
            titleContentColor = titleColor,
        ),
        scrollBehavior = scrollBehavior,
        modifier = modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewCenterTopAppBarLight() {
    UicomposablesTheme {
        Surface {
            ComposesCenterAppBar(
                title = {
                    ComposesText20(
                        text = "UI Components"
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewCenterTopAppBarDark() {
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            ComposesCenterAppBar(
                title = {
                    ComposesText20(
                        text = "UI Components"
                    )
                },
            )
        }
    }
}