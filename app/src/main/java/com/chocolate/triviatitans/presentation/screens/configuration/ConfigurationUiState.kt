package com.chocolate.triviatitans.presentation.screens.configuration

data class ConfigurationUiState(
    val title: String,
    val description: String,
    val image: Int,
    val currentIndex: Int,
    val index: Int,
    val selected: (Int) -> Unit
)
