package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.home.homeRoute
import com.chocolate.triviatitans.presentation.screens.level.levelRoute
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.wordWiseRoute

@Composable
fun TriviaNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ){
        homeRoute(navController)
        wordWiseRoute(navController)
        levelRoute(navController)
    }
}