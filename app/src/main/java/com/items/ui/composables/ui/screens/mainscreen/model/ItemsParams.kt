package com.drivin.android.ui.screens.mainscreen.model

data class ItemsParams(
    val label: String,
    val navGoTo: () -> Unit
)