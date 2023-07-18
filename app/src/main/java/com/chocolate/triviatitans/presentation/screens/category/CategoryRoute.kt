package com.chocolate.triviatitans.presentation.screens.category

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.CategoryArgs.Companion.GAME_TYPE_NAME
import com.chocolate.triviatitans.presentation.screens.home.GameType

fun NavGraphBuilder.categoryRoute(navController: NavController) {
    composable(
        "${Screens.CategoryScreen.route}/{$GAME_TYPE_NAME}",
        arguments = listOf(
            navArgument(GAME_TYPE_NAME) { NavType.StringType}
        )) {
        CategoryScreen(navController = navController)
    }
}

fun NavController.navigateToCategory(gameType: GameType) {
    navigate("${Screens.CategoryScreen.route}/${gameType.name}")
}

class CategoryArgs(savedStateHandle: SavedStateHandle){
    val gameTypeName: String = checkNotNull(savedStateHandle[GAME_TYPE_NAME])
    companion object{
        const val GAME_TYPE_NAME = "gameTypeName"
    }
}