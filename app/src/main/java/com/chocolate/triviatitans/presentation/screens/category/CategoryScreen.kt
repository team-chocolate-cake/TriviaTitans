package com.chocolate.triviatitans.presentation.screens.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.category.components.BottomBar
import com.chocolate.triviatitans.presentation.screens.category.components.Content
import com.chocolate.triviatitans.presentation.screens.category.components.TopBar
import com.chocolate.triviatitans.presentation.screens.category.viewmodel.CategoriesUiState
import com.chocolate.triviatitans.presentation.screens.category.viewmodel.CategoryUiState
import com.chocolate.triviatitans.presentation.screens.category.viewmodel.CategoryViewModel
import com.chocolate.triviatitans.presentation.screens.level.navigateToLevel
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun CategoryScreen(
    navController: NavController,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CategoryContent(
        state = state,
        onCategorySelected = viewModel::onCategorySelected,
        onCategoryDeselected = viewModel::onCategoryDeselected,
        onClickNext = {
            val category = state.categoriesSelected.joinToString(",") { it.name }
            navController.navigateToLevel(category, viewModel.categoryArgs.gameTypeName)
        },
        onClickBack = { navController.navigateUp() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryContent(
    state: CategoriesUiState,
    onCategorySelected: (CategoryUiState) -> Unit,
    onCategoryDeselected: (CategoryUiState) -> Unit,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit
) {
    val colors = MaterialTheme.customColor()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.background,
        topBar = {
            TopBar(
                title = stringResource(R.string.you_want_to_improve_today),
                onBackClick = onClickBack,
            )
        },
        bottomBar = {
            BottomBar(
                count = state.categoriesSelectedCount,
                onNextClick = onClickNext,
            )
        }
    )
    { padding ->
        Content(
            padding = padding,
            categories = state.categories,
            onCategorySelected = { category, isSelected ->
                if (isSelected) onCategorySelected(category)
                else onCategoryDeselected(category)
            }
        )
    }
}

@Preview
@Composable
fun CategoryScreenPreview() {
    TriviaTitansTheme {
        // CategoryScreen()
    }
}