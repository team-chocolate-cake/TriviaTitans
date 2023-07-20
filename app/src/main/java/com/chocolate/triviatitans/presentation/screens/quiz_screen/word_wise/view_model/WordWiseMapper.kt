package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper

class WordWiseMapper : Mapper<TextChoiceEntity, WordWiseUIState.QuestionUiState> {
    override fun map(input: TextChoiceEntity): WordWiseUIState.QuestionUiState {
        return WordWiseUIState.QuestionUiState(
            id = input.id,
            question = input.question,
            difficulty = input.difficulty,
            correctAnswer = input.correctAnswer.uppercase()
                .replace(" ", "-"),
            correctAnswerLetters = input.correctAnswer.uppercase()
                .replace(" ", "-")
                .toList()
        )
    }
}