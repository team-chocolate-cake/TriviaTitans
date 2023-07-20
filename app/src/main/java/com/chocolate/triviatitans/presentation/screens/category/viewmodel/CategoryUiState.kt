package com.chocolate.triviatitans.presentation.screens.category.viewmodel


data class CategoriesUiState(
    val categories: List<CategoryUiState> = emptyList(),
    val categoriesSelectedCount: Int = 0,
    val categoriesSelected: List<CategoryUiState> = listOf(),
)

data class CategoryUiState(
    val id: Int = 0,
    val name: String = "",
    val title: String = "",
    val image: Int = 0,
    val progress: Float = 0.6f,
    val isSelected:Boolean = false
)

