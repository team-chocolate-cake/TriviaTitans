package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.categoryRoute
import com.chocolate.triviatitans.presentation.screens.home.homeRoute
import com.chocolate.triviatitans.presentation.screens.level.levelRoute
import com.chocolate.triviatitans.presentation.screens.lose.loseRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.imageGameRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.textGameRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.wordWiseRoute
import com.chocolate.triviatitans.presentation.screens.spinWheel.spinWheelRoute
import com.chocolate.triviatitans.presentation.screens.win.winRoute

@Composable
fun TriviaNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        homeRoute(navController)
        categoryRoute(navController)
        levelRoute(navController)
        imageGameRoute(navController)
        textGameRoute(navController)
        wordWiseRoute(navController)
        loseRoute(navController)
        spinWheelRoute(navController)
        winRoute(navController)
    }
}