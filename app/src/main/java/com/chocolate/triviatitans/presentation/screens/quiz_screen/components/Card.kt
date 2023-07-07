package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

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
import com.chocolate.triviatitans.presentation.theme.LightBorder
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun Card(questionAlphabet: Char, question: String, isCorrectAnswer: Boolean) {
    val cardColor = TriviaCustomColors.current
    val answerColor = remember { mutableStateOf(cardColor.card) }
    val errorColor = TriviaCustomColors.current.error
    val correctColor = TriviaCustomColors.current.correct

    Box(Modifier.clip(RoundedCornerShape(12.dp))) {
        Row(modifier = Modifier
            .clickable { answerColor.value = if (isCorrectAnswer) correctColor else errorColor }
            .background(color = answerColor.value)
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = questionAlphabet.toString(), color = cardColor.onBackground87)
            SpacerHorizontal8Dp()
            Divider(
                color = LightBorder,
                modifier = Modifier
                    .height(28.dp)
                    .width(1.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            SpacerHorizontal8Dp()
            Text(text = question, color = cardColor.onBackground87)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CardPreview() {
    TriviaTitansTheme() {
        Card('A', "Soccer", false)
    }
}