package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.CategoryArgs.Companion.CURRENT_INDEX
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs.Companion.CATEGORIES
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs.Companion.GAME_TYPE
import com.chocolate.triviatitans.presentation.screens.quiz_screen.QuizArgs.Companion.LEVEL_TYPE

fun NavGraphBuilder.quizRoute(navController: NavHostController) {
    composable(
        "${Screens.QuizScreen.route}/{$CATEGORIES}/{$GAME_TYPE}/{$LEVEL_TYPE}",
        arguments = listOf(
            navArgument(CATEGORIES) { NavType.StringType },
            navArgument(GAME_TYPE) { NavType.IntType },
            navArgument(LEVEL_TYPE) { NavType.StringType }
        )
    ) {
        QuizScreen(navController = navController)
    }
}

fun NavController.navigateToQuiz(categories: String="", gameType: Int=0, levelArgs: String="") {
    navigate("${Screens.QuizScreen.route}/$categories/$gameType/$levelArgs")
}

class QuizArgs(savedStateHandle: SavedStateHandle){
    val levelType = checkNotNull(savedStateHandle[LEVEL_TYPE])
    companion object{
        const val LEVEL_TYPE = "level_type"
    }
}