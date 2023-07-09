package com.chocolate.triviatitans.presentation.screens.home

data class HomeUiState(
    val title: String = "",
    val description: String = "",
    val image: Int = 0,
    val currentIndex: Int = 0,
    val index: Int = 0,
    val selected: (Int) -> Unit = {}
)