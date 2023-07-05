package com.chocolate.triviatitans.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.TriviaCustomColors
import com.chocolate.triviatitans.ui.theme.TriviaTitansTheme
import com.chocolate.triviatitans.ui.theme.Typography
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CategoryCard(category: String) {
    val colors = TriviaCustomColors.current
    var isSelected by remember { mutableStateOf(false) }
        Card(
            colors = CardDefaults.cardColors(colors.card),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    isSelected = !isSelected
                },
            shape = RoundedCornerShape(12.dp),
            border = if(isSelected)BorderStroke(1.dp, colors.gameOver) else null
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.CenterVertically
                ),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Category Image",
                )

                Text(
                    text = category,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    color = colors.onBackground87
                )

                LinearProgressIndicator(
                    color = colors.gameOver,
                    progress = 0.5f,
                    modifier = Modifier
                        .height(6.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }



@Preview()
@Composable
fun CategoryScreenPreview() {
    CategoryCard("text")
}