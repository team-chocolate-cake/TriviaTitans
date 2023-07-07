package com.chocolate.triviatitans.screen.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.screen.category.components.BottomBar
import com.chocolate.triviatitans.screen.category.components.TopBar
import com.chocolate.triviatitans.screen.category.components.Content
import com.chocolate.triviatitans.ui.theme.TriviaCustomColors
import com.chocolate.triviatitans.ui.theme.TriviaTitansTheme
import com.chocolate.triviatitans.viewmodel.category.CategoriesUiState
import com.chocolate.triviatitans.viewmodel.category.CategoryUiState
import com.chocolate.triviatitans.viewmodel.category.CategoryViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    CategoryContent(
        state = state,
    ) { category, isSelected ->
        if (isSelected) viewModel.onCategorySelected(category)
        else viewModel.onCategoryDeselected(category)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryContent(
    state: CategoriesUiState,
    onCategorySelected: (CategoryUiState, Boolean) -> Unit
) {
    val colors = TriviaCustomColors.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.background,
        topBar = {
            TopBar(
                title = "You want to improve today?",
                onBackClick = { /*TODO*/ },
            )
        },
        bottomBar = {
            BottomBar(
                count = state.categoriesSelectedCount.toString(),
                onNextClick = { /*TODO*/ },
            )
        }
    )
    { padding ->
        Content(
            padding = padding,
            categories = state.categories,
            onCategorySelected = onCategorySelected
        )
    }
}

@Preview
@Composable
fun CategoryScreenPreview() {
    TriviaTitansTheme {
        CategoryScreen()
    }
}