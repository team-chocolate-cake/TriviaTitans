package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.ui.theme.Primary

@Composable
fun ButtonConfirm(onClickConfirm: () -> Unit) {
    Button(
        onClick = { onClickConfirm() },
        colors = ButtonDefaults.buttonColors(Primary),
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .background(
                color = Primary,
                shape = RoundedCornerShape(size = 12.dp)

            ),
    ) {
        Row() {
            Icon(
                modifier = Modifier.padding(PaddingValues(horizontal = 16.dp, vertical = 8.dp)),
                painter = painterResource(id = com.google.android.material.R.drawable.ic_mtrl_chip_checked_circle),
                contentDescription = null,
            )
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
