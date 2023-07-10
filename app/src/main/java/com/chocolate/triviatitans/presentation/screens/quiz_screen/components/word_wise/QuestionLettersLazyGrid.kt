package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.word_wise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuestionLettersLazyGird(
    charsList: List<Char>,
    selectedLetterList: List<Char>,
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
            val value = (selectedLetterList + List(charsList.size) { ' ' })[index]
            CorrectAnswerTextCard(
                text = value,
            )
        }
    }
}

@Preview
@Composable
fun QuestionLettersLazyGirdPreview() {
    QuestionLettersLazyGird(
        charsList = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'),
        selectedLetterList = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I')
    )
}

