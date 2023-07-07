package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.spacer.horizontal.SpacerHorizontal8
import com.chocolate.triviatitans.presentation.theme.Correct

@Preview(showSystemUi = true)
@Composable
fun Grid() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(4) { item ->
            Image(
                painter = rememberAsyncImagePainter("https://img.freepik.com/free-photo/portrait-handsome-man-with-dark-hairstyle-bristle-toothy-smile-dressed-white-sweatshirt-feels-very-glad-poses-indoor-pleased-european-guy-being-good-mood-smiles-positively-emotions-concept_273609-61405.jpg"),
                contentDescription = "",
                modifier = Modifier
                    .border(BorderStroke(1.dp, Correct), shape = RoundedCornerShape(12.dp))
                    .height(height = 261.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxSize(),

                contentScale = ContentScale.Crop,
//                .size(width = 161.dp , height = 231.dp)
            )
        }

    }

}