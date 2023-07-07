package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.CustomColorsPalette

@Composable
fun SubTitleText(color: CustomColorsPalette) {
    Text(
        text = stringResource(R.string.sub_title_descripation_level),
        color = color.onBackground60,
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentWidth()
            .padding(bottom = 24.dp, start = 42.dp, end = 42.dp)
    )
}