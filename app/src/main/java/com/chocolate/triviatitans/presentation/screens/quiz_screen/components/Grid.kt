package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.Correct

@Preview(showSystemUi = true)
@Composable
fun Grid(){
    val items = listOf("Item 1", "Item 2","Item 3", "Item 4")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(4) { item ->
            Image(painter = painterResource(id = R.drawable.image_test)
                , contentDescription ="",
            modifier = Modifier
                .border(BorderStroke(1.dp,Correct ))
                .fillMaxWidth()
                )
        }
    }

}