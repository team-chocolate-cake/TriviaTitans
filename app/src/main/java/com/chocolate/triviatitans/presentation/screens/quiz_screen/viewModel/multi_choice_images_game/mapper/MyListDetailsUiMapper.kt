package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.mapper

import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.ImageChoiceUIState
import javax.inject.Inject

class MultiChoiceImagesGameUiMapper @Inject constructor() :
    Mapper<ImageChoiceEntity, ImageChoiceUIState> {
    override fun map(input: ImageChoiceEntity): ImageChoiceUIState {
        return ImageChoiceUIState(
            id = input.id,
            category = input.category,
            correctAnswer = input._correctAnswer,
            incorrectAnswer = input._incorrectAnswer,
            question = input.question,
            difficulty = input.difficulty,
        )
    }
}