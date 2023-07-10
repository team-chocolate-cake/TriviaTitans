package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.word_wise

import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper

class WordWiseMapper : Mapper<TextChoiceEntity, WordWiseUIState.QuestionUiState> {
    override fun map(input: TextChoiceEntity): WordWiseUIState.QuestionUiState {
        return WordWiseUIState.QuestionUiState(
            id = input.id,
            question = input.question,
            category = input.category,
            difficulty = input.difficulty,
            correctAnswer = input.correctAnswer,
            correctAnswerLetters = input.correctAnswer.uppercase()
                .replace(" ", "-")
                .toList().shuffled()
        )
    }
}