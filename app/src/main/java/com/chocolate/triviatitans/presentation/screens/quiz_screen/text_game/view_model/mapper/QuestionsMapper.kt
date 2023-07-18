package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model.mapper

import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.QuestionUiState
import javax.inject.Inject

class QuestionsMapper @Inject constructor() : Mapper<TextChoiceEntity, QuestionUiState> {
    override fun map(input: TextChoiceEntity): QuestionUiState {
        return QuestionUiState(
            id = input.id,
            question = input.question,
            category = input.category,
            difficulty = input.difficulty,
            correctAnswer = input.correctAnswer,
            incorrectAnswers = input.incorrectAnswers
        )
    }
}