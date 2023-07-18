package com.chocolate.triviatitans.presentation.screens.level.viewModel

import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class ScoreMapper @Inject constructor() : Mapper<LocalPlayerDataDto, ScoreByLevel> {
    override fun map(input: LocalPlayerDataDto): ScoreByLevel {
        return ScoreByLevel(
            easy = input.easyScore,
            medium = input.mediumScore,
            hard = input.hardScore,
        )
    }
}