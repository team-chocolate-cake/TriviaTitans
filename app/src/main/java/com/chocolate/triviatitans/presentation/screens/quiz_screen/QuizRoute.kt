package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.quizRoute(navController: NavHostController){
    composable(route = Screens.QuizScreen.route){
        QuizScreen(navController)
    }
}