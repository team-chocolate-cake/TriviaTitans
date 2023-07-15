package com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice.mapper

import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice.MultiChoiceTextUiState
import javax.inject.Inject

class MultiChoiceImagesGameUiMapper @Inject constructor() :
    Mapper<ImageChoiceEntity, MultiChoiceTextUiState.QuestionUiState> {
    override fun map(input: ImageChoiceEntity): MultiChoiceTextUiState.QuestionUiState {
        return MultiChoiceTextUiState.QuestionUiState(
            id = input.id,
            category = input.category,
            correctAnswer = input.correctAnswer[0].imageUrl,
            incorrectAnswers = input.incorrectAnswer,
            question = input.question,
            difficulty = input.difficulty,
        )
    }
}