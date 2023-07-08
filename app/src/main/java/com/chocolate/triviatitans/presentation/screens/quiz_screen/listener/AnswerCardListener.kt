package com.chocolate.triviatitans.presentation.screens.quiz_screen.listener

interface AnswerCardListener {
    fun onClickCard(question: String, questionNumber: Int,isCorrectAnswer:Boolean)
    fun updateButtonState(value:Boolean)
}