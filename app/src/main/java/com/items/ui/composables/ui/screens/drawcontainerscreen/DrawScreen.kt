package com.items.ui.composables.ui.screens.drawcontainerscreen

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composes.R
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composables.ui.theme.UicomposablesTheme
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.drawcontainer.ComposesDrawContainer
import com.items.ui.text.ComposesText16
import com.items.ui.text.ComposesText18
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DrawScreen(navGo: NavGo) {
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_draw_screen),
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
        DrawContent(
            paddingValues = paddingValues
        )
    }
}

@Composable
private fun DrawContent(
    paddingValues: PaddingValues
) {
    var bitMapState by remember { mutableStateOf<Bitmap?>(null) }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
    ) {
        ComposesText16(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.label_draw_with_event_touch),
        )
        ComposesHorizontalDivider()
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            ComposesDrawContainer(
                onBitmapResult = { bitmap ->
                    bitMapState = bitmap
                },
                toastMessage = stringResource(
                    id = R.string.message_for_save_image_first_draw_some
                )
            )
            ComposesText18(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.label_preview_image_screen),
            )
            ComposesHorizontalDivider()
            bitMapState?.asImageBitmap()?.let { imageBitMap ->
                Image(
                    modifier = Modifier.padding(top = 10.dp),
                    bitmap = imageBitMap,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewDrawScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            DrawScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewDrawScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            DrawScreen(
                navGo = navGo
            )
        }
    }
}