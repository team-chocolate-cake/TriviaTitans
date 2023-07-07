package com.chocolate.triviatitans.screen.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.screen.category.components.BottomBar
import com.chocolate.triviatitans.screen.category.components.TopBar
import com.chocolate.triviatitans.screen.category.components.CategoryCard
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
        state,
        onCategorySelected = { category, isSelected ->
            if (isSelected) viewModel.onCategorySelected(category)
            else viewModel.onCategoryDeselected(category)
        }
    )
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
        LazyVerticalGrid(
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding().plus(16.dp),
                bottom = padding.calculateBottomPadding().plus(16.dp),
                start = 16.dp,
                end = 16.dp
            ),
            columns = GridCells.Fixed(count = 2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = state.categories,
                key = { category -> category.name }
            ) { category ->
                CategoryCard(
                    category = category,
                    onClick = { isSelected ->
                        onCategorySelected(category, isSelected)
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun CategoryScreenPreview() {
    TriviaTitansTheme {
        CategoryScreen()
    }
}