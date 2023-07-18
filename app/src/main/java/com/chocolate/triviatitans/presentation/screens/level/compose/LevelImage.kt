package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.ImageView

@Composable
fun LevelImage() {
    ImageView(
        ImageResource = R.drawable.level_image,
        contentDescription = stringResource(R.string.level_image),
        modifier = Modifier
            .fillMaxWidth()
    )
}