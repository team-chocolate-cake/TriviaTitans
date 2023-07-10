package com.chocolate.triviatitans.presentation.screens.level

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs.Companion.CATEGORY_ARGS
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs.Companion.GAME_TYPE

fun NavGraphBuilder.levelRoute(navController: NavController) {
    composable(
        "${Screens.LevelScreen.route}/${CATEGORY_ARGS}/${GAME_TYPE}",
        arguments = listOf(
            navArgument(CATEGORY_ARGS) { NavType.StringArrayType},
            navArgument(GAME_TYPE){NavType.IntType}
        )
    ) {
        LevelScreen(navController = navController)
    }
}
fun NavController.navigateToLevel(category: String) {
    navigate("${Screens.LevelScreen.route}/$category")
}

class LevelArgs(savedStateHandle: SavedStateHandle) {
    val category: String = checkNotNull(savedStateHandle[CATEGORY_ARGS])
    val gameType :Int= checkNotNull(savedStateHandle[GAME_TYPE])
    companion object {
        const val CATEGORY_ARGS = "category"
        const val GAME_TYPE = "game_type"
    }
}