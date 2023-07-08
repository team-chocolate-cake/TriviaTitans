package com.chocolate.triviatitans.presentation.screens.category.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun BottomBar(
    count: String,
    onNextClick: () -> Unit
) {
    val colors = TriviaCustomColors.current

    Surface(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        color = colors.card,
        shadowElevation = 20.dp,
        tonalElevation = 20.dp,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.total_select),
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.onBackground60
                )
                Text(
                    text = count,
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.primary
                )
            }
            Button(
                onClick = onNextClick,
                contentPadding = PaddingValues(horizontal = 60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
            ) {
                Text(
                    text = stringResource(R.string.next),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    TriviaTitansTheme {
        BottomBar(
            count = "10",
            onNextClick = {}
        )
    }
}
