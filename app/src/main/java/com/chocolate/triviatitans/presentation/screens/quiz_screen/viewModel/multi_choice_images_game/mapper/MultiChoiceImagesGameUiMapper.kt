package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.mapper

import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.ImageChoiceUIState
import javax.inject.Inject

class MultiChoiceImagesGameUiMapper @Inject constructor(
    private val mapperInCorrectAnswerUiMapper: InCorrectAnswerUiMapper,
) :
    Mapper<ImageChoiceEntity, ImageChoiceUIState> {
    override fun map(input: ImageChoiceEntity): ImageChoiceUIState {
        return ImageChoiceUIState(
            id = input.id,
            category = input.category,
            correctAnswer = input._correctAnswer,
            incorrectAnswer = mapperInCorrectAnswerUiMapper.mapNested(input.incorrectAnswer ?: emptyList()),
                    question = input.question,
            difficulty = input.difficulty,
        )
    }
}