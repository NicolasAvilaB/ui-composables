package com.items.ui.composables.ui.model

import android.content.Context
import com.items.ui.composables.R
import com.items.ui.composables.ui.navigation.NavGo

fun listElements(
    context: Context,
    navGo: NavGo
) = arrayListOf(
    ItemsParams(
        label = context.getString(R.string.label_loading_screen),
        navGoTo = { navGo.loading.invoke() }
    )
)