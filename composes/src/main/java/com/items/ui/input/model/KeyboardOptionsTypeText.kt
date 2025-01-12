package com.items.ui.input.model

import androidx.compose.ui.text.input.KeyboardType

data class KeyboardOptionsTypeText(
    val keyboardType: CustomKeyboardTypeText
) {
    fun getKeyboardType(): KeyboardType {
        return when (keyboardType) {
            CustomKeyboardTypeText.Text -> KeyboardType.Text
            CustomKeyboardTypeText.Email -> KeyboardType.Email
        }
    }
}
