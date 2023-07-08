package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.mapper

import com.chocolate.triviatitans.domain.entities.InCorrectAnswerImageEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.InCorrectAnswerImageUIState
import javax.inject.Inject

class InCorrectAnswerUiMapper @Inject constructor() :
    Mapper<InCorrectAnswerImageEntity, InCorrectAnswerImageUIState> {
    override fun map(input: InCorrectAnswerImageEntity): InCorrectAnswerImageUIState {
        return InCorrectAnswerImageUIState(
            imageUrl = input.imageUrl ?: ""
        )
    }
}