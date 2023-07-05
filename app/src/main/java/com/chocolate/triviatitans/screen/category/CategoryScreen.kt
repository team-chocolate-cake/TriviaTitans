package com.chocolate.triviatitans.screen.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composable.CategoryCard
import com.chocolate.triviatitans.ui.theme.Typography


@Composable
fun CategoryScreen() {
    val categories = listOf(
        "Geography",
        "Music",
        "Sport and leisure",
        "Movie and Tv",
        "Arts and literature",
        "History",
        "Society and culture",
        "Science",
        "General Knowledge",
        "Food And Drink"
    )

    CategoryContent(categories)
}

@Composable
fun CategoryContent(categories: List<String>) {

    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Fixed(count = 2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(span = { GridItemSpan(2) }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Back Arrow",
                    )
                }

                Text(
                    text = "You want to improve today?",
                    style = Typography.titleMedium,
                )
            }
        }
        items(
            items = categories
        ) { category ->
            CategoryCard(category = category)
        }
    }


}

@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen()
}