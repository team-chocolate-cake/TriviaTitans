package com.chocolate.triviatitans.viewmodel.category


data class CategoriesUiState(
    val isLoading: Boolean = false,
    val categories: List<CategoryUiState> = emptyList(),
    val categoriesSelected: Int = 0,
    val error: String? = null
)

data class CategoryUiState(
    val name: String = "",
    val title: String = "",
    val image: Int = 0,
    val progress: Float = 0.6f,
    val isSelected: Boolean = false
)


