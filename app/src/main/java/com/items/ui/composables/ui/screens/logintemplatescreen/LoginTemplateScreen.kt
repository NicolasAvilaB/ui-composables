package com.items.ui.composables.ui.screens.logintemplatescreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.items.ui.button.ComposesButtonArrowBack
import com.items.ui.composables.ui.navigation.NavGo
import com.items.ui.composes.R
import com.items.ui.login.ComposesLoginTemplate
import com.items.ui.text.ComposesText18
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.topbar.ComposesTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoginTemplateScreen(navGo: NavGo) {
    val emailInput = remember { mutableStateOf("") }
    val passInput = remember { mutableStateOf("") }
    val errorEmailInput = remember { mutableStateOf(false) }
    val errorPassInput = remember { mutableStateOf(false) }
    val errorEmailMessage = remember { mutableStateOf("") }
    val errorPassMessage = remember { mutableStateOf("") }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            ComposesTopAppBar(
                title = {
                    ComposesText18(
                        text = stringResource(id = R.string.label_login_screen),
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
            modifier = Modifier.padding(paddingValues)
        ) {
            ComposesLoginTemplate(
                emailInput = emailInput,
                passInput = passInput,
                versionPackage = "1.03",
                errorEmailInput = errorEmailInput,
                errorPassInput = errorPassInput,
                errorMessageEmail = errorEmailMessage,
                errorMessagePass = errorPassMessage
            ) {
                Toast.makeText(context, R.string.label_login_screen,Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLoginTemplateScreenLight() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme {
        Surface {
            LoginTemplateScreen(
                navGo = navGo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewELoginTemplateScreenDark() {
    val context = LocalContext.current
    val navGo = NavGo(NavHostController(context))
    UicomposablesTheme(
        darkTheme = true
    ) {
        Surface {
            LoginTemplateScreen(
                navGo = navGo
            )
        }
    }
}