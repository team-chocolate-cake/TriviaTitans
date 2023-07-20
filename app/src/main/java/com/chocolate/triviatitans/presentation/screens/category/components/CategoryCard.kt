package com.chocolate.triviatitans.presentation.screens.category.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.ImageView
import com.chocolate.triviatitans.presentation.screens.category.viewmodel.CategoryUiState
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun CategoryCard(
    category: CategoryUiState,
    onClick: (Boolean) -> Unit
) {
    val colors = MaterialTheme.customColor()
    Card(
        colors = CardDefaults.cardColors(colors.card),
        modifier = Modifier
            .width(160.dp)
            .height(146.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ){
                onClick(category.isSelected)
            },
        border = if (category.isSelected) BorderStroke(1.dp, colors.primary) else null,
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
            ImageView(
                ImageResource = category.image,
                contentDescription = stringResource(R.string.category_image),
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp),
            )
            Text(
                text = category.title,
                style = MaterialTheme.typography.titleMedium,
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
                image = R.drawable.category_art,
                progress = 0.5f,
                isSelected = false
            ), onClick = {}
        )
    }
}