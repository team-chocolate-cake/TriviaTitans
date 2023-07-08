package com.chocolate.triviatitans.presentation.screens.quiz_screen

interface AnswerCardListener {
    fun onClickCard(question: String, questionNumber: Int)
    fun updateButtonState(value:Boolean)
}