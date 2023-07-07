package com.chocolate.triviatitans.screen.category.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.screen.category.CategoryScreen
import com.chocolate.triviatitans.ui.theme.TriviaTitansTheme
import com.chocolate.triviatitans.viewmodel.category.CategoryUiState

@Composable
fun Content(
    padding: PaddingValues,
    categories: List<CategoryUiState>,
    onCategorySelected: (CategoryUiState, Boolean) -> Unit
) {
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
            items = categories,
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