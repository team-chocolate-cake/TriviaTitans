package com.chocolate.triviatitans.composable

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.TriviaCustomColors
import com.chocolate.triviatitans.ui.theme.TriviaTitansTheme
import com.chocolate.triviatitans.ui.theme.Typography

@Composable
fun CategoryCard(category: String) {

        Card(
            colors = CardDefaults.cardColors(TriviaCustomColors.current.card),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            /*border = BorderStroke(1.dp, Primary)*/
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
                    style = Typography.bodySmall,
                )

                LinearProgressIndicator(
                    progress = 1f,
                    modifier = Modifier
                        .height(6.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }


@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryCard("text")
}