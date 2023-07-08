package com.chocolate.triviatitans.presentation

sealed class Screens(val route: String){
    object LevelScreen: Screens("levelScreen")
    object WordWiseScreen: Screens("wordWiseScreen")

    object QuizScreen: Screens("quizScreen")

    object HomeScreen: Screens("homeScreen")

}
