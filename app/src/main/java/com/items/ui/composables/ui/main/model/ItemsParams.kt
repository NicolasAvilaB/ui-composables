package com.items.ui.composables.ui.main.model

data class ItemsParams(
    val label: String,
    val navGoTo: () -> Unit
)
