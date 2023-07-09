package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.home.homeRoute
import com.chocolate.triviatitans.presentation.screens.level.levelRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.quizRoute
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.wordWiseRoute

@Composable
fun TriviaNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        homeRoute(navController)
        wordWiseRoute(navController)
        levelRoute(navController)
        quizRoute(navController)

    }
}