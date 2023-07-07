package com.chocolate.triviatitans.viewmodel.category


data class CategoriesUiState(
    val categories: List<CategoryUiState> = emptyList(),
    val categoriesSelectedCount: Int = 0,
    val categoriesSelected: List<CategoryUiState> = listOf(),
)

data class CategoryUiState(
    val name: String = "",
    val title: String = "",
    val image: Int = 0,
    val progress: Float = 0.6f,
)


