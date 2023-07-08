package com.chocolate.triviatitans.ui.screens.level

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.ui.Screen
import com.chocolate.triviatitans.ui.screens.level.LevelArgs.Companion.CATEGORY_ARGS

fun NavGraphBuilder.levelRoute(navController: NavController) {
    composable(
        "${Screen.LevelScreen.route}/${CATEGORY_ARGS}",
        arguments = listOf(
            navArgument(CATEGORY_ARGS) { NavType.StringType }
        )) {
        LevelScreen(navController = navController)
    }
}

fun NavController.navigateToLevel(category: String) {
    navigate("${Screen.LevelScreen.route}/$category")
}

class LevelArgs(savedStateHandle: SavedStateHandle) {
    val category: String = checkNotNull(savedStateHandle[CATEGORY_ARGS])

    companion object {
        const val CATEGORY_ARGS = "category"
    }
}