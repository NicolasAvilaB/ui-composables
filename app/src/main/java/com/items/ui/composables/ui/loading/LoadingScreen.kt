package com.items.ui.composables.ui.loading

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.loading.ComposesCentralLoading
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoadingScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = "UI Loading",
                        color = Color.White,
                    )
                },
                color = MaterialTheme.colorScheme.primary,
                navigationButton = {
                    ComposesButtonArrowBack(
                        onClick = { navGo.popBackStack.invoke() },
                        color = Color.White
                    )
                }
            )
        },
    ) { paddingValues ->
        ComposesCentralLoading(modifier = Modifier.padding(paddingValues))
    }
}