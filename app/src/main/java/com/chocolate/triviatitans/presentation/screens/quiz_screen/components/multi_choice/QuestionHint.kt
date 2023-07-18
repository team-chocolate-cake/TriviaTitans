package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.ImageView
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun QuestionHint(
    @DrawableRes icon: Int,
    numberOfTries: Int,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val questionHintColor = MaterialTheme.customColor()
    Box(
        modifier = modifier
            .size(64.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        ImageView(
            ImageResource =icon,
            contentDescription = "question help",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .clickable(onClick = onClick)
                .background(questionHintColor.primary)
                .then(imageModifier)
        )
        Text(
            color = questionHintColor.primary,
            modifier = Modifier
                .padding(PaddingValues(4.dp))
                .drawBehind {
                    drawCircle(
                        color = questionHintColor.onSecondary,
                        radius = 20f
                    )
                },
            text = numberOfTries.toString(),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun QuestionHintPreview() {
    TriviaTitansTheme() {
        QuestionHint(
            icon = R.drawable.ic_heart,
            3,
            modifier = Modifier.padding(16.dp), onClick = {}
        )
    }
}