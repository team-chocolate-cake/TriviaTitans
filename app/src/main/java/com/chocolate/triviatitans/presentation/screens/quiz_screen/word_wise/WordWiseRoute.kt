package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseGameArgs.Companion.CATEGORIES
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseGameArgs.Companion.LEVEL_TYPE

fun NavGraphBuilder.wordWiseRoute(navController: NavHostController) {
    composable(
        "${Screens.WordWiseScreen.route}/{${CATEGORIES}}/{${LEVEL_TYPE}}",
        arguments = listOf(
            navArgument(CATEGORIES) { NavType.StringType },
            navArgument(LEVEL_TYPE) { NavType.StringType }
        )
    ) {
        WordWiseScreen(navController = navController)
    }
}

fun NavController.navigateToWordWise(categories: String="",levelArgs: String="") {
    navigate("${Screens.WordWiseScreen.route}/$categories/${levelArgs.lowercase()}")
}

class WordWiseGameArgs(savedStateHandle: SavedStateHandle){
    val categories: String = checkNotNull(savedStateHandle[CATEGORIES])
    val levelType: String = checkNotNull(savedStateHandle[LEVEL_TYPE])

    companion object{
        const val CATEGORIES = "categories"
        const val LEVEL_TYPE = "level_type"
    }
}