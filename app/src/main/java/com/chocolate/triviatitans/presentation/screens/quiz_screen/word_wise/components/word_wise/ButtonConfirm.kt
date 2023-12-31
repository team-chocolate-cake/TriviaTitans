package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.Primary
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun ButtonConfirm(onClickConfirm: () -> Unit, modifier: Modifier =Modifier) {
    Button(
        modifier = modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .height(57.dp)
            .background(
                color = Primary,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        colors = ButtonDefaults.buttonColors(Primary),
        onClick = { onClickConfirm() },
    ) {
        Row() {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight(),
                text = "Confirm",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.firasans_medium)),
                    fontWeight = FontWeight(600),
                    color = TriviaCustomColors.current.secondary,
                )
            )
        }
    }
}
