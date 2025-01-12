package com.items.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.items.ui.button.ComposesPrimaryButton
import com.items.ui.composes.R
import com.items.ui.input.ComposesEmailInput
import com.items.ui.input.ComposesPasswordInput
import com.items.ui.text.ComposesText16
import com.items.ui.theme.UicomposablesTheme
import com.items.ui.theme.isLight

@Composable
fun ComposesLoginTemplate(
    emailInput: MutableState<String>,
    passInput: MutableState<String>,
    errorEmailInput: MutableState<Boolean>,
    errorPassInput: MutableState<Boolean>,
    errorMessageEmail: MutableState<String>,
    errorMessagePass: MutableState<String>,
    versionPackage: String,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(bottom = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp),
                painter = checkingDarkTheme(),
                contentScale = ContentScale.FillWidth,
                contentDescription = stringResource(id = R.string.text_logo),
            )
            ComposesEmailInput(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp
                ),
                inputValue = emailInput,
                errorInput = errorEmailInput.value,
                errorMessage = errorMessageEmail.value,
                onValueChange = { }
            )
            ComposesPasswordInput(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp
                ),
                passValue = passInput,
                errorInput = errorPassInput.value,
                errorMessage = errorMessagePass.value,
                onValueChange = { }
            )
            ComposesPrimaryButton(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .width(150.dp)
                    .height(60.dp),
                onClick = onClickButton,
                textContent = stringResource(id = R.string.enter_action)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComposesText16(
                text = "WareHouse",
                fontWeight = FontWeight.Bold
            )
            ComposesText16(
                text = "Version ${versionPackage}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
internal fun checkingDarkTheme(): Painter {
    val isLight = MaterialTheme.colorScheme.isLight()
    if (isLight)
        return painterResource(id = coil.base.R.drawable.ic_100tb)
    else
        return painterResource(id = coil.base.R.drawable.ic_100tb)
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLoginTemplateLight() {
    UicomposablesTheme {
        Surface {
            val emailInput = remember { mutableStateOf("") }
            val passInput = remember { mutableStateOf("") }
            val errorEmailInput = remember { mutableStateOf(false) }
            val errorPassInput = remember { mutableStateOf(false) }
            val errorEmailMessage = remember { mutableStateOf("") }
            val errorPassMessage = remember { mutableStateOf("") }
            ComposesLoginTemplate(
                emailInput = emailInput,
                passInput = passInput,
                versionPackage = "1.03",
                errorEmailInput = errorEmailInput,
                errorPassInput = errorPassInput,
                errorMessageEmail = errorEmailMessage,
                errorMessagePass = errorPassMessage
            ) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLoginTemplateDark() {
    UicomposablesTheme(darkTheme = true) {
        Surface {
            val emailInput = remember { mutableStateOf("") }
            val passInput = remember { mutableStateOf("") }
            val errorEmailInput = remember { mutableStateOf(false) }
            val errorPassInput = remember { mutableStateOf(false) }
            val errorEmailMessage = remember { mutableStateOf("") }
            val errorPassMessage = remember { mutableStateOf("") }
            ComposesLoginTemplate(
                emailInput = emailInput,
                passInput = passInput,
                versionPackage = "1.03",
                errorEmailInput = errorEmailInput,
                errorPassInput = errorPassInput,
                errorMessageEmail = errorEmailMessage,
                errorMessagePass = errorPassMessage
            ) { }
        }
    }
}
