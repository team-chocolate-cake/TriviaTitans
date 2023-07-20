package com.chocolate.triviatitans.presentation.screens.quiz_screen.listener

interface AnswerCardListener {
    fun onClickCard(isCorrectAnswer:Boolean)
    fun updateButtonState(value:Boolean)
}