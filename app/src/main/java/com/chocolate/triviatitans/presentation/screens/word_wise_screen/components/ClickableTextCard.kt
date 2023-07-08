package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.Primary
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun ClickableTextCard(text: String, onClick: (String) -> Unit) {
    val isSelected = remember { mutableStateOf(false) }

    if (isSelected.value) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Primary,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .background(Primary, shape = RoundedCornerShape(size = 12.dp))
                .clickable {
                    isSelected.value = false
                    onClick(text)
                }
        ) {
            Text(
                text = text, modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                textAlign = TextAlign.Center,
                color = TriviaCustomColors.current.secondary
            )
        }
    } else {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Primary,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .clickable {
                    isSelected.value = true
                    onClick(text)
                }

        ) {
            Text(
                text = text, modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                textAlign = TextAlign.Center,
                color = Primary
            )
        }
    }
}
