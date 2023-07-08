package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.mapper

import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState

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