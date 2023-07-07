package com.chocolate.triviatitans.screen.category.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.chocolate.triviatitans.viewmodel.category.CategoryUiState

@Composable
fun CategoryCard(
    category: CategoryUiState,
    onClick: (Boolean) -> Unit
) {
    val colors = TriviaCustomColors.current
    var isBorder by rememberSaveable { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(colors.card),
        modifier = Modifier
            .width(160.dp)
            .height(146.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                isBorder = !isBorder
                onClick(isBorder)
            },
        border = if (isBorder) BorderStroke(1.dp, colors.primary) else null,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically
            ),
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp),
                painter = painterResource(id = category.image),
                contentDescription = "Category Image",
            )

            Text(
                text = category.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 14.sp,
                color = colors.onBackground87
            )

            LinearProgressIndicator(
                trackColor = colors.onSecondary,
                color = colors.primary,
                progress = category.progress,
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
    TriviaTitansTheme {
        CategoryCard(
            CategoryUiState(
                title = "Category",
                image = R.drawable.ic_launcher_foreground,
                progress = 0.5f
            ), onClick = {})
    }
}