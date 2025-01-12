package com.items.ui.composables.ui.screens.settingscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingViewModel : ViewModel(){
    var darkTheme by mutableStateOf(false)
}