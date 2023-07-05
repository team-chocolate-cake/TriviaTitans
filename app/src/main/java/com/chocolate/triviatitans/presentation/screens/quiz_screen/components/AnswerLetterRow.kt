package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.Primary

@Composable
fun AnswerLetterRow(Word: String) {
    val chars = Word.uppercase().toList()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(24.dp),
    contentPadding = PaddingValues(16.dp)
    ) {
        items(chars.size) { index ->
            AnswerLetterCard(text = chars[index].toString(), textColor = Primary)
        }
    }

}

@Preview
@Composable
fun Test() {
    AnswerLetterRow("footballdvjvnjvdvokdlnvkf")
}


