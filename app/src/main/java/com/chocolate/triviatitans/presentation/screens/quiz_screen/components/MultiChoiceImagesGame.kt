package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState

import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import java.util.Timer
import kotlin.concurrent.schedule

@Composable
fun MultiChoiceImagesGame(
    state: MultiChoiceTextUiState,
    question: MultiChoiceTextUiState.QuestionUiState,
    answerCardListener: AnswerCardListener,
    isButtonsEnabled: Boolean
) {
    val answerColor = remember { mutableStateOf(Color(0x00F8F8F8)) }
    val isCorrectAnswer = remember { mutableStateOf(false) }
    val errorColor: Color = TriviaCustomColors.current.error
    val correctColor: Color = TriviaCustomColors.current.correct

    var selectedIndex = remember { mutableStateOf(-1) }


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = rememberLazyGridState(),
        content = {
            itemsIndexed(question.randomAnswers) { index, item ->
                Image(
                    painter = rememberAsyncImagePainter(item),
                    contentDescription = "",
                    modifier = Modifier
                        .height(height = 200f.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxSize()
                        .clickable(enabled = isButtonsEnabled) {

                            selectedIndex.value = index
                            isCorrectAnswer.value = item == question.correctAnswer
                            answerColor.value =
                                if (isCorrectAnswer.value) correctColor else errorColor

                            answerCardListener.updateButtonState(false)

                            Timer().schedule(500) {
                                answerCardListener.onClickCard(
                                    item,
                                    state.questionNumber,
                                    isCorrectAnswer.value
                                )
                                answerColor.value = Color(0x00F8F8F8)
                                answerCardListener.updateButtonState(true)
                            }

                        }
                        .border(
                            BorderStroke(
                                2.dp, if (selectedIndex.value == index) {
                                    answerColor.value
                                } else Color(0x00F8F8F8)
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentScale = ContentScale.Crop,
                )
            }

        }
    )
}