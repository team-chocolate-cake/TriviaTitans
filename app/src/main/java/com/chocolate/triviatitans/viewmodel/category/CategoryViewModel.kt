package com.chocolate.triviatitans.viewmodel.category

import androidx.lifecycle.ViewModel
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(CategoriesUiState())
    val state = _state.asStateFlow()


    init {
        getCategories()
    }

    private fun getCategories() {
        _state.update { it.copy(categories = categories()) }
    }

    fun onCategorySelected(categoryUiState: CategoryUiState) {
        val updated = categoryUiState.copy(isSelected = !categoryUiState.isSelected)
        _state.update { categoriesUiState ->
            categoriesUiState.copy(categories = categoriesUiState.categories.map {
                if (it.name == updated.name) updated else it
            })
        }
    }

    fun updateSelectedCategories() {
        _state.update { categoriesUiState ->
            categoriesUiState.copy(categoriesSelected = categoriesUiState.categories.count { it.isSelected })
        }
    }


    private fun categories(): List<CategoryUiState> {
        return listOf(
            CategoryUiState("geography", "Geography", R.drawable.category_geography),
            CategoryUiState("music", "Music", R.drawable.category_music),
            CategoryUiState("sport_and_leisure", "Sport and leisure", R.drawable.category_sport),
            CategoryUiState("film_and_tv", "Movie and Tv", R.drawable.category_movies),
            CategoryUiState("arts_and_literature", "Arts and literature", R.drawable.category_art),
            CategoryUiState("history", "History", R.drawable.category_history),
            CategoryUiState(
                "society_and_culture",
                "Society and culture",
                R.drawable.category_society
            ),
            CategoryUiState("science", "Science", R.drawable.category_science),
            CategoryUiState("general_knowledge", "General Knowledge", R.drawable.category_general),
            CategoryUiState("food_and_drink", "Food And Drink", R.drawable.category_food),
        )
    }

}