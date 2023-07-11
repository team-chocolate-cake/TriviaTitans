package com.chocolate.triviatitans.presentation.screens.level

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.levelRoute(navController: NavController) {
    composable(
        "${Screens.LevelScreen.route}/{categories}/{game_type}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType},
            navArgument("game_type"){NavType.IntType}
        )
    ) {
        LevelScreen(navController = navController)
    }
}
fun NavController.navigateToLevel(categories: String,gameType:Int) {
    navigate("${Screens.LevelScreen.route}/$categories/$gameType")
}

/*
class LevelArgs(savedStateHandle: SavedStateHandle) {
    val category: String = checkNotNull(savedStateHandle[CATEGORY_ARGS])
    val gameType :Int= checkNotNull(savedStateHandle[GAME_TYPE])
    companion object {
        const val CATEGORY_ARGS = "category"
        const val GAME_TYPE = "game_type"
    }
}*/
