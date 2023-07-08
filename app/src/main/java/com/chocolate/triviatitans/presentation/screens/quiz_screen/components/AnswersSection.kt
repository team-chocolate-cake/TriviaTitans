package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.presentation.common.type.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.MultiChoiceImagesGameViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.MultiChoiceImagesGameUIState

@Composable
fun AnswersSection(
    state: MultiChoiceImagesGameUIState,
    gameType: String = GameType.image_choice.name
) {

    when (gameType) {

        GameType.text_choice.name -> {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Card('A', "Soccer", true)
                Card('B', "Swimming", false)
                Card('C', "Tennis", false)
                Card('D', "Baseball", false)
            }
        }

        GameType.image_choice.name -> {
            MultiChoiceImagesGame(state)
        }
        
        GameType.word_wise.name ->{}
    }
}
