package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.TextGameArgs.Companion.CATEGORIES
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.TextGameArgs.Companion.LEVEL_TYPE
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseScreen

fun NavGraphBuilder.textGameRoute(navController: NavHostController) {
    composable(
        "${Screens.TextGameScreen.route}/{$CATEGORIES}/{$LEVEL_TYPE}",
        arguments = listOf(
            navArgument(CATEGORIES) { NavType.StringType },
            navArgument(LEVEL_TYPE) { NavType.StringType }
        )
    ) {
        TextGameScreen(navController = navController)
    }
}

fun NavController.navigateToTextGame(categories: String="",levelArgs: String="") {
    navigate("${Screens.TextGameScreen.route}/$categories/${levelArgs.lowercase()}")
}

class TextGameArgs(savedStateHandle: SavedStateHandle){
    val categories: String = checkNotNull(savedStateHandle[CATEGORIES])
    val levelType: String = checkNotNull(savedStateHandle[LEVEL_TYPE])

    companion object{
        const val CATEGORIES = "categories"
        const val LEVEL_TYPE = "level_type"
    }
}