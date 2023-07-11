package com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel

import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper

class WordWiseMapper : Mapper<TextChoiceEntity, WordWiseUIState.QuestionUiState> {
    override fun map(input: TextChoiceEntity): WordWiseUIState.QuestionUiState {
        return WordWiseUIState.QuestionUiState(
            id = input.id,
            question = input.question,
            category = input.category,
            difficulty = input.difficulty,
            correctAnswer = input.correctAnswer.uppercase()
                .replace(" ", "-")
                .toList()
        )
    }
}