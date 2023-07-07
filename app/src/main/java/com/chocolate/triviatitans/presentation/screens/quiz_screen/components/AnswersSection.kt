package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.GameType

@Composable
fun AnswersSection(
    gameType: String = "Multi_Choice_Images"
) {

    when (gameType) {

        GameType.Multi_Choice.name -> {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Card('A', "Soccer", true)
                Card('B', "Swimming", false)
                Card('C', "Tennis", false)
                Card('D', "Baseball", false)
            }
        }

        GameType.Multi_Choice_Images.name -> {
            AnswerImageGrid()
        }
        GameType.Word_Wise.name ->{}

    }
}

@Preview(showSystemUi = true)
@Composable
fun AnswersSectionPreview() {
    AnswersSection()
}
