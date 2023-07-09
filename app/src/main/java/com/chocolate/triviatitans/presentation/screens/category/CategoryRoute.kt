package com.chocolate.triviatitans.presentation.screens.category

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.LevelArgs.Companion.Games_ARGS
import com.chocolate.triviatitans.presentation.screens.level.LevelScreen

fun NavGraphBuilder.categoryRoute(navController: NavController) {
    composable(
        "${Screens.CategoryScreen.route}/${Games_ARGS}",
        arguments = listOf(
            navArgument(Games_ARGS) { NavType.IntType}
        )) {
        CategoryScreen(navController = navController)
    }
}
fun NavController.navigateToCategory(selectedGame: Int) {
    navigate("${Screens.CategoryScreen.route}/$selectedGame")
}

class LevelArgs(savedStateHandle: SavedStateHandle) {
    val selectedGame: Int = checkNotNull(savedStateHandle[Games_ARGS])

    companion object {
        const val Games_ARGS = "selectedGame"
    }
}


