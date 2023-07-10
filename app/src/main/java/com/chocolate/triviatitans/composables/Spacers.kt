package com.chocolate.triviatitans.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerHorizontal4(){
    Spacer(modifier = Modifier.width(4.dp))
}
@Composable
fun SpacerHorizontal8(){
    Spacer(modifier = Modifier.width(8.dp))
}
@Composable
fun SpacerHorizontal24(){
    Spacer(modifier = Modifier.width(24.dp))

}


@Composable
fun SpacerVertical4(){
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun SpacerVertical8(){
    Spacer(modifier = Modifier.height(8.dp))
}
@Composable
fun SpacerVertical16(){
    Spacer(modifier = Modifier.height(16.dp))
}
@Composable
fun SpacerVertical24(){
    Spacer(modifier = Modifier.height(24.dp))
}
@Composable
fun SpacerVertical32(){
    Spacer(modifier = Modifier.height(32.dp))
}