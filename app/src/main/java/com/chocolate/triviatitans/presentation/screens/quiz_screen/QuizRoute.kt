package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs

fun NavGraphBuilder.quizRoute(navController: NavHostController){
    composable(route = Screens.QuizScreen.route){
        QuizScreen(navController)
    }
}
fun NavController.navigateToQuiz(gameType: LevelArgs , levelArgs: LevelArgs,) {
    navigate("${Screens.QuizScreen.route}/$gameType/$levelArgs")
}