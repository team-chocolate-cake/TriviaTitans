package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.mapper

import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.QuestionUiState
import javax.inject.Inject

class ImageGameUiMapper @Inject constructor() :
    Mapper<ImageChoiceEntity, QuestionUiState> {
    override fun map(input: ImageChoiceEntity): QuestionUiState {
        return QuestionUiState(
            id = input.id,
            category = input.category,
            correctAnswer = input.correctAnswer[0].imageUrl,
            incorrectAnswers = input.incorrectAnswer,
            question = input.question,
            difficulty = input.difficulty,
        )
    }
}