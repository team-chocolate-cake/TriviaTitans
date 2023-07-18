package com.chocolate.triviatitans.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ImageView(modifier:Modifier = Modifier,ImageResource: Int, contentDescription: String? = null , ) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(ImageResource)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier
    )
}