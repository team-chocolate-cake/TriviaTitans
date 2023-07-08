package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuestionLettersLazyGird(
    charsList: List<Char>,
    selectedLetterList: List<String>,
    modifier: Modifier = Modifier,
) {

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Adaptive(24.dp),
        contentPadding = PaddingValues(16.dp),
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(charsList.size) { index ->
            ClickableTextCard(
                text = selectedLetterList[index].ifEmpty { " " },
                onClick = { false }
            )
        }

    }
}

