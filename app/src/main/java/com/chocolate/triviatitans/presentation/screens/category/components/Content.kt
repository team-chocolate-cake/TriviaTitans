package com.chocolate.triviatitans.presentation.screens.category.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.category.viewmodel.CategoryUiState

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
            key = { category -> category.id }
        ) { category ->
            CategoryCard(
                category = category,
                onClick = { isSelected ->
                    Log.e("TAG", "Content: $isSelected", )
                    onCategorySelected(category, !isSelected)
                }
            )
        }
    }
}