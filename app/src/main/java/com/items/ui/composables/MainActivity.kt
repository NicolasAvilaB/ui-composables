package com.items.ui.composables

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.items.ui.composables.ui.screens.settingscreen.SettingViewModel
import com.items.ui.composables.ui.navigation.NavController
import com.items.ui.theme.UicomposablesTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<SettingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UicomposablesTheme(darkTheme = viewModel.darkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavController(
                        fragmentActivity = this,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
