package com.chocolate.triviatitans.presentation.screens.category.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.category.CategoryArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(CategoriesUiState())
    val state = _state.asStateFlow()
   // val args = checkNotNull(savedStateHandle.get<Int>("index"))

    val args = checkNotNull(savedStateHandle["index"])

    init {
        getCategories()
    }

    private fun getCategories() {
        _state.update { it.copy(categories = categories()) }
        Log.d("index", args.toString())
    }

    fun onCategorySelected(categoryUiState: CategoryUiState) {
        _state.update {
            it.copy(
                categoriesSelected = it.categoriesSelected + categoryUiState,
                categoriesSelectedCount = it.categoriesSelectedCount + 1
            )
        }
    }

    fun onCategoryDeselected(categoryUiState: CategoryUiState) {
        _state.update {
            it.copy(
                categoriesSelected = it.categoriesSelected - categoryUiState,
                categoriesSelectedCount = it.categoriesSelectedCount - 1
            )
        }
    }

    private fun categories(): List<CategoryUiState> {
        return listOf(
            CategoryUiState(1, "geography", "Geography", R.drawable.category_geography),
            CategoryUiState(2, "music", "Music", R.drawable.category_music),
            CategoryUiState(3, "sport_and_leisure", "Sport and leisure", R.drawable.category_sport),
            CategoryUiState(4, "film_and_tv", "Movie and Tv", R.drawable.category_movies),
            CategoryUiState(
                5,
                "arts_and_literature",
                "Arts and literature",
                R.drawable.category_art
            ),
            CategoryUiState(6, "history", "History", R.drawable.category_history),
            CategoryUiState(
                7,
                "society_and_culture",
                "Society and culture",
                R.drawable.category_society
            ),
            CategoryUiState(8, "science", "Science", R.drawable.category_science),
            CategoryUiState(
                9,
                "general_knowledge",
                "General Knowledge",
                R.drawable.category_general
            ),
            CategoryUiState(10, "food_and_drink", "Food And Drink", R.drawable.category_food),
        )
    }
}