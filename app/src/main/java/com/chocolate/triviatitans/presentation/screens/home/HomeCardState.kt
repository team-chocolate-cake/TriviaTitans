package com.chocolate.triviatitans.presentation.screens.home

data class HomeUiState(
    val homeCards:List<HomeCardState> = emptyList(),
    val selectedHomeCardIndex:Int = -1
)

data class HomeCardState(
    val title: String = "",
    val description: String = "",
    val image: Int = 0,
    val currentIndex: Int = 0,
)
