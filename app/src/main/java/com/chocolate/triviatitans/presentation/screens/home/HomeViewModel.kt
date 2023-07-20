package com.chocolate.triviatitans.presentation.screens.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getHomeCard()
    }

    fun changeSelectedGameType(gameType: GameType){
        _state.update { it.copy(selectedGameType = gameType) }
    }

    private fun getHomeCard() {
        _state.update { it.copy(homeCards = homeCards()) }
    }

    private fun homeCards(): List<HomeCardState> {
        return listOf(
            HomeCardState(
                gameType = GameType.MULTI_CHOICE,
                description ="Answer questions and choose the correct option to test your knowledge",
                image = R.drawable.configuratoin_multi_choice_icon,
            ),
            HomeCardState(
                gameType = GameType.MULTI_CHOICE_IMAGES,
                description = "Identify the correct image that matches the given question to showcase your visual expertise.",
                image = R.drawable.configuratoin_multi_choice_images_icon,
            ),
            HomeCardState(
                gameType = GameType.WORD_WISE,
                description = "Unscramble letters to discover hidden words in this addictive language puzzle game.",
                image = R.drawable.configuratoin_word_wise_icon,
            )
        )
    }
}