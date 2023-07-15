package com.chocolate.triviatitans.presentation.screens.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chocolate.triviatitans.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getHomeCard()
    }

    fun changeSelectedCardIndex(index:Int){
        _state.update { it.copy(selectedHomeCardIndex = index) }
    }

    private fun getHomeCard() {
        _state.update { it.copy(homeCards = homeCards()) }
    }

    private fun homeCards(): List<HomeCardState> {
        return listOf(
            HomeCardState(
                title ="Multi Choice",
                description ="Answer questions and choose the correct option to test your knowledge",
                image = R.drawable.configuratoin_multi_choice_icon,
                currentIndex = 0,
            ),
            HomeCardState(
                title = "Multi Choice Images",
                description = "Identify the correct image that matches the given question to showcase your visual expertise.",
                image = R.drawable.configuratoin_multi_choice_images_icon,
                currentIndex = 1,
            ),
            HomeCardState(
                title = "Word Wise",
                description = "Unscramble letters to discover hidden words in this addictive language puzzle game.",
                image = R.drawable.configuratoin_word_wise_icon,
                currentIndex = 2,
            )
        )
    }
}