package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel

import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper

class QuizQuestionsMapper: Mapper<TextChoiceEntity, MultiChoiceTextUiState.QuestionUiState> {
    override fun map(input: TextChoiceEntity): MultiChoiceTextUiState.QuestionUiState {
        return MultiChoiceTextUiState.QuestionUiState(
            id = input.id,
            question = input.question,
            category = input.category,
            difficulty = input.difficulty,
            correctAnswer = input.correctAnswer,
            incorrectAnswers = input.incorrectAnswers
        )
    }
}