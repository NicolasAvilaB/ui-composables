package com.items.ui.composables.ui.model

data class ItemsParams(
    val label: String,
    val navGoTo: () -> Unit
)
