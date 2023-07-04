package com.chocolate.triviatitans.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R

@Composable
fun ConfigurationCard(typeTitle:String,typeDescription:String,typeImage: Int,
color: Color = Color.White
){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp)
        .height(120.dp),
        colors = CardDefaults.cardColors(color)
    ) {
        Row(modifier = Modifier.fillMaxSize(), Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)
                .padding(start = 12.dp),
                verticalArrangement = Arrangement.Center) {
                Text(text = typeTitle)
                Text(text = typeDescription
                    , maxLines = 3,
                    textAlign = TextAlign.Justify
                )
            }
            Spacer(Modifier.size( 24.dp))
            Image(modifier = Modifier
                .fillMaxHeight()
                .padding(end = 12.dp),painter = painterResource(id = typeImage), contentDescription =null )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewConfigurationCard(){
    ConfigurationCard("test",
        "desc",
        R.drawable.configration_multi_choice_images_icon)
}