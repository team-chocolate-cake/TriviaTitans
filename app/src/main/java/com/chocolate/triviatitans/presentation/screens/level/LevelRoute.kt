package com.chocolate.triviatitans.presentation.screens.level

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs.Companion.CATEGORIES
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs.Companion.GAME_TYPE

fun NavGraphBuilder.levelRoute(navController: NavController) {
    composable(
        "${Screens.LevelScreen.route}/{$CATEGORIES}/{$GAME_TYPE}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType},
            navArgument("game_type"){NavType.IntType}
        )
    ) {
        LevelScreen(navController = navController)
    }
}
fun NavController.navigateToLevel(categories: String="",gameType:Int=0) {
    navigate("${Screens.LevelScreen.route}/$categories/$gameType")
}

class LevelArgs(savedStateHandle: SavedStateHandle){
    val categories = checkNotNull(savedStateHandle[CATEGORIES])
    val gameType = checkNotNull(savedStateHandle[GAME_TYPE])
    companion object{
        const val CATEGORIES = "categories"
        const val GAME_TYPE = "game_type"
    }
}