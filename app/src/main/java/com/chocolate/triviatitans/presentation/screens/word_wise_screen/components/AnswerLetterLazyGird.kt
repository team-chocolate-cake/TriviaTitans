package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.Primary

@Composable
fun AnswerLetterLazyGird(Word: String) {
    val chars = Word.uppercase().toList()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(24.dp),
        contentPadding = PaddingValues(16.dp),
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(chars.size) { index ->
            AnswerLetterCard(text = chars[index].toString(), textColor = Primary)
        }
    }
}

@Preview
@Composable
fun Test() {
    AnswerLetterLazyGird("bjgkb gfl gfdm ldm dklcsmk")
}


