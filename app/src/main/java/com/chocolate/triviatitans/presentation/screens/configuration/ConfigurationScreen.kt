package com.chocolate.triviatitans.presentation.screens.configuration

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun ConfigurationScreen() {
    TriviaTitansTheme() {
        ConfigurationContent()
    }
}

@Composable
fun ConfigurationContent() {

    var selectedIndex by remember {
        mutableStateOf(-1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TriviaCustomColors.current.background)
            .padding(16.dp)
    ) {
        LazyColumn() {
            item {
                Text(
                    text = stringResource(id = R.string.game_type),
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                    fontSize = 16.sp,
                    color = TriviaCustomColors.current.onBackground87
                )
            }
            item {
                ConfigurationCard(typeTitle = stringResource(id = R.string.config_title_card1),
                    typeDescription = stringResource(id = R.string.config_content_card1),
                    typeImage = R.drawable.configuratoin_multi_choice_icon,
                    currentIndex = 1,
                    index = selectedIndex,
                    selected = { i -> selectedIndex = i })
            }
            item {
                ConfigurationCard(typeTitle = stringResource(id = R.string.config_title_card2),
                    typeDescription = stringResource(id = R.string.config_content_card2),
                    typeImage = R.drawable.configuratoin_multi_choice_images_icon,
                    currentIndex = 2,
                    index = selectedIndex,
                    selected = { i -> selectedIndex = i })

            }
            item {
                ConfigurationCard(typeTitle = stringResource(id = R.string.config_title_card3),
                    typeDescription = stringResource(id = R.string.config_content_card3),
                    typeImage = R.drawable.configuratoin_word_wise_icon,
                    currentIndex = 3,
                    index = selectedIndex,
                    selected = { i -> selectedIndex = i })
            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(120.dp),
                    colors = CardDefaults.cardColors(TriviaCustomColors.current.onSecondary)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(), Arrangement.SpaceBetween,
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.5f)
                                .padding(start = 12.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.config_title_card4),
                                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                                fontSize = 16.sp,
                                color = TriviaCustomColors.current.primary
                            )

                            Text(
                                text = stringResource(id = R.string.config_content_card4),
                                maxLines = 3,
                                textAlign = TextAlign.Justify,
                                fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                fontSize = 22.sp,
                                color = TriviaCustomColors.current.primary
                            )

                        }
                        Spacer(Modifier.size(24.dp))
                        Image(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(end = 12.dp),
                            painter = painterResource(id = R.drawable.configuratoin_coming_soon_icon),
                            contentDescription = null
                        )
                    }
                }

            }
        }

        if (selectedIndex != -1) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(250.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 38.dp),
                colors = ButtonDefaults.buttonColors(TriviaCustomColors.current.primary),

                ) {
                Text(
                    text = stringResource(id = R.string.play_now),
                    fontFamily = MaterialTheme.typography.titleMedium.fontFamily, fontSize = 20.sp
                )
            }
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewConfigurationScreen() {
    ConfigurationScreen()
}