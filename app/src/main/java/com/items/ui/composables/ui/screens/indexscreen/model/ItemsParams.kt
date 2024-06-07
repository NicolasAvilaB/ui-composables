package com.items.ui.composables.ui.screens.indexscreen.model

data class ItemsParams(
    val label: String,
    val navGoTo: () -> Unit
)
