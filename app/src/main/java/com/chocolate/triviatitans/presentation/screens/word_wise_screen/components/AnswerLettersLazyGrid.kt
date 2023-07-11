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
fun AnswerLettersLazyGrid(
    charsList: List<Char>,
    selectedLetterList: List<Char>,
    modifier: Modifier = Modifier,
    onAnswerCardClicked: (Int) -> Unit, // Callback for deleting a character
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
            AnswerTextCard(
                text = value,
                onAnswerCardClicked = { onAnswerCardClicked(index) } // Call the onDeleteCharacter callback
            )
        }
    }
}


