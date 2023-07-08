package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.WordWiseRoute

@Composable
fun TriviaNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.WordWiseScreen.route
    ){
        WordWiseRoute(navController)
    }
}