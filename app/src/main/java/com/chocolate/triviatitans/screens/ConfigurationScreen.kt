package com.chocolate.triviatitans.screens

import android.content.res.Resources.Theme
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composable.ConfigurationCard
import com.chocolate.triviatitans.ui.theme.DarkBackground
import com.chocolate.triviatitans.ui.theme.Primary
import com.chocolate.triviatitans.ui.theme.Purple80

@Composable
fun ConfigurationScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xF1F1F1F1))
        .padding(16.dp)) {

        Text(text = "Game Type", modifier = Modifier.padding(vertical = 8.dp) )


        ConfigurationCard(typeTitle = "Multi Choice"
            , typeDescription = "Answer questions and choose the correct option to test your knowledge "
            , typeImage =R.drawable.configration_multi_choice_icon )

        ConfigurationCard(typeTitle = "Multi Choice"
            , typeDescription = "Answer questions and choose the correct option to test your knowledge "
            , typeImage =R.drawable.configration_multi_choice_images_icon )

        ConfigurationCard(typeTitle = "Multi Choice"
            , typeDescription = "Answer questions and choose the correct option to test your knowledge "
            , typeImage =R.drawable.configration_word_wise_icon )

        ConfigurationCard(typeTitle = "Multi Choice"
            , typeDescription = "Answer questions and choose the correct option to test your knowledge "
            , typeImage =R.drawable.configuration_coming_soon_icon
        ,   Purple80
        )


        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .width(250.dp)
            .align(Alignment.CenterHorizontally)
            .padding(38.dp),
            colors = ButtonDefaults.buttonColors(Primary)
        ) {
            Text(text = "Play Now")

        }


      



    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewConfigurationScreen(){
    ConfigurationScreen()
}