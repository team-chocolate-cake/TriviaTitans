package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.ImageGameArgs.Companion.CATEGORIES
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.ImageGameArgs.Companion.LEVEL_TYPE

fun NavGraphBuilder.imageGameRoute(navController: NavHostController) {
    composable(
        "${Screens.ImageGameScreen.route}/{$CATEGORIES}/{$LEVEL_TYPE}",
        arguments = listOf(
            navArgument(CATEGORIES) { NavType.StringType },
            navArgument(LEVEL_TYPE) { NavType.StringType }
        )
    ) {
       ImageGameScreen(navController = navController)
    }
}

fun NavController.navigateToImageGame(categories: String="",levelArgs: String="") {
    navigate("${Screens.ImageGameScreen.route}/$categories/${levelArgs.lowercase()}")
}

class ImageGameArgs(savedStateHandle: SavedStateHandle){
    val categories: String = checkNotNull(savedStateHandle[CATEGORIES])
    val levelType: String = checkNotNull(savedStateHandle[LEVEL_TYPE])

    companion object{
        const val CATEGORIES = "categories"
        const val LEVEL_TYPE = "level_type"
    }
}
