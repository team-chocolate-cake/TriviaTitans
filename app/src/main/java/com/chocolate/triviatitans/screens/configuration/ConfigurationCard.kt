package com.chocolate.triviatitans.screens.configuration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.TriviaCustomColors

@Composable
fun ConfigurationCard(typeTitle:String,
                      typeDescription:String,
                      typeImage: Int,
color: Color = TriviaCustomColors.current.card,
                      currentIndex:Int,
                      index:Int,
                      selected:(Int)->Unit
){

       Card(modifier = Modifier
           .fillMaxWidth()
           .padding(top = 8.dp)
           .height(120.dp).
           clickable { selected(currentIndex)},
           colors = CardDefaults.cardColors(color),
           border = if(currentIndex==index) BorderStroke(2.dp, TriviaCustomColors.current.primary) else null
       ) {
           Row(modifier = Modifier.fillMaxSize(), Arrangement.SpaceBetween,
           ) {
               Column(modifier = Modifier
                   .fillMaxHeight()
                   .weight(0.5f)
                   .padding(start = 12.dp),
                   verticalArrangement = Arrangement.Center) {
                   Text(text = typeTitle,
                       fontFamily = MaterialTheme.typography.titleMedium.fontFamily
                   ,fontSize = 16.sp
                   ,color = TriviaCustomColors.current.onBackground87)

                   Text(text = typeDescription
                       , maxLines = 3,
                       textAlign = TextAlign.Justify,
                       fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                   ,fontSize = 12.sp
                   ,color = TriviaCustomColors.current.onBackground60)

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
        "test2",
        R.drawable.configration_multi_choice_images_icon,currentIndex=3,index=0){}
}