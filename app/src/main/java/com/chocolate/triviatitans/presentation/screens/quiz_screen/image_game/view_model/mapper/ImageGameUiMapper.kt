package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.mapper

import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.ImageGameUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice.MultiChoiceTextUiState
import javax.inject.Inject

class ImageGameUiMapper @Inject constructor() :
    Mapper<ImageChoiceEntity, ImageGameUiState.QuestionUiState> {
    override fun map(input: ImageChoiceEntity): ImageGameUiState.QuestionUiState {
        return ImageGameUiState.QuestionUiState(
            id = input.id,
            category = input.category,
            correctAnswer = input.correctAnswer[0].imageUrl,
            incorrectAnswers = input.incorrectAnswer,
            question = input.question,
            difficulty = input.difficulty,
        )
    }
}