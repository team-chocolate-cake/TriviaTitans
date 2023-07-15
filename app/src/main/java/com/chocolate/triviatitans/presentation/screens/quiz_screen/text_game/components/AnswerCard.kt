package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.composables.SpacerHorizontal8
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice.SpacerHorizontal8Dp
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.LightBorder
import java.util.Timer
import kotlin.concurrent.schedule

@Composable
fun AnswerCard(
    answerAlphabet: Char,
    answer: String,
    answerCardListener: AnswerCardListener,
    questionNumber: Int,
    correctAnswer: String,
    isButtonsEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    val cardColor = TriviaCustomColors.current
    val answerColor = remember { mutableStateOf(cardColor.card) }

    Box(Modifier.clip(RoundedCornerShape(12.dp))) {
        Row(modifier = modifier
            .clickable(enabled = isButtonsEnabled) {
                val isCorrectAnswer = answer == correctAnswer
                answerColor.value =
                    if (answer == correctAnswer) cardColor.correct else cardColor.error
                answerCardListener.updateButtonState(false)
                Timer().schedule(500) {
                    answerCardListener.onClickCard(answer, questionNumber, isCorrectAnswer)
                    answerColor.value = cardColor.card
                    answerCardListener.updateButtonState(true)
                }
            }
            .background(color = answerColor.value)
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = answerAlphabet.toString(), color = cardColor.onBackground87)
            SpacerHorizontal8()
            Divider(
                color = LightBorder,
                modifier = Modifier
                    .height(28.dp)
                    .width(1.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            SpacerHorizontal8()
            Text(text = answer, color = cardColor.onBackground87)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CardPreview() {
    TriviaTitansTheme() {
        AnswerCard('A', "Soccer", object : AnswerCardListener {
            override fun onClickCard(
                question: String,
                questionNumber: Int,
                isCorrectAnswer: Boolean
            ) {
                TODO("Not yet implemented")
            }

            override fun updateButtonState(value: Boolean) {
                TODO("Not yet implemented")
            }


        }, questionNumber = 0, "", true)
    }
}