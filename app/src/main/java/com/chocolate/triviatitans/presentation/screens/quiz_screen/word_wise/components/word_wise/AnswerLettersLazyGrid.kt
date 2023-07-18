package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnswerLettersLazyGrid(
    charsList: List<Char>,
    selectedLetterList: List<Char>,
    onAnswerCardClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 64.dp, max = 208.dp),
        columns = GridCells.Adaptive(24.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(charsList.size) { index ->
            AnswerTextCard(
                text = (selectedLetterList + List(charsList.size) { ' ' })[index],
                onAnswerCardClicked = { onAnswerCardClicked(index) }
            )
        }
    }
}

@Preview
@Composable
fun AnswerLettersLazyGridPreview() {
    AnswerLettersLazyGrid(
        charsList = listOf('a', 'a', 'd'),
        selectedLetterList = listOf('a', 'a', 'd'),
        onAnswerCardClicked = {})
}

