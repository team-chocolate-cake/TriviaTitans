package com.chocolate.triviatitans.presentation

sealed class Screens(val route: String){
    object HomeScreen: Screens("HomeScreen")
    object CategoryScreen: Screens("CategoryScreen")
    object LevelScreen: Screens("LevelScreen")
    object WordWiseScreen: Screens("WordWiseScreen")
    object QuizScreen: Screens("QuizScreen")
    object SpinWheelScreen: Screens("SpinWheelScreen")
    object WinScreen: Screens("WinScreen")

}
