package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.CustomColorsPalette

@Composable
fun ItemLevel(
    color: CustomColorsPalette,
    text: String,
    tint: Color = Color(0xFFEDECEF),
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .height(120.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_level),
            contentDescription = "level $text",
            tint = tint,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp, bottom = 8.dp)
        )
        Text(
            text = text,
            color = Color(0xFFEDECEF),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp),
            maxLines = 1
        )
    }
}