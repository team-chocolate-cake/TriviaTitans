package com.chocolate.triviatitans.presentation.screens.category

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.chocolate.triviatitans.presentation.Screens

fun NavController.navigateToLevel(category: String) {
    navigate("${Screens.LevelScreen.route}/$category")
}

class LevelArgs(savedStateHandle: SavedStateHandle) {
    val category: String = checkNotNull(savedStateHandle[CATEGORY_ARGS])

    companion object {
        const val CATEGORY_ARGS = "category"
    }
}