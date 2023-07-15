package com.chocolate.triviatitans.presentation.screens.home

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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.category.navigateToCategory
import com.chocolate.triviatitans.presentation.screens.spinWheel.navigateToSpinWheelScreen
import com.chocolate.triviatitans.presentation.screens.win.navigateToWinScreen
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun HomeScreen(
    navController: NavController
) {
    TriviaTitansTheme {
        HomeContent(
            onClickButton = { selectedGame ->
                navController.navigateToCategory(selectedGame)
            }
        )
    }
}

@Composable
fun HomeContent(
    onClickButton: (Int) -> Unit,
) {
    var selectedIndex by rememberSaveable {
        mutableStateOf(-1)
    }
    val configurations = listOf(
        HomeUiState(
            title = stringResource(id = R.string.config_title_card1),
            description = stringResource(id = R.string.config_content_card1),
            image = R.drawable.configuratoin_multi_choice_icon,
            currentIndex = 0,
            index = selectedIndex,
            selected = { i -> selectedIndex = i }
        ),
        HomeUiState(
            title = stringResource(id = R.string.config_title_card2),
            description = stringResource(id = R.string.config_content_card2),
            image = R.drawable.configuratoin_multi_choice_images_icon,
            currentIndex = 1,
            index = selectedIndex,
            selected = { i -> selectedIndex = i }
        ),
        HomeUiState(
            title = stringResource(id = R.string.config_title_card3),
            description = stringResource(id = R.string.config_content_card3),
            image = R.drawable.configuratoin_word_wise_icon,
            currentIndex = 2,
            index = selectedIndex,
            selected = { i -> selectedIndex = i }
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.customColor().background)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.game_type),
            modifier = Modifier.padding(top = 24.dp),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.customColor().onBackground87,
            textAlign = TextAlign.Start
        )
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(configurations) { configurationCard ->
                ConfigurationCard(
                    typeTitle = configurationCard.title,
                    typeDescription = configurationCard.description,
                    typeImage = configurationCard.image,
                    currentIndex = configurationCard.currentIndex,
                    index = configurationCard.index,
                    selected = configurationCard.selected
                )
            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(120.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.customColor().onSecondary)
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
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.customColor().onBackground38
                            )

                            Text(
                                text = stringResource(id = R.string.config_content_card4),
                                maxLines = 3,
                                textAlign = TextAlign.Justify,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.customColor().onBackground87
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
            item {
                if (selectedIndex != -1) {
                    Button(
                        onClick = {
                            onClickButton(selectedIndex)
                        },
                        modifier = Modifier
                            .width(250.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 38.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.customColor().primary),

                        ) {
                        Text(
                            text = stringResource(id = R.string.play_now),
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                }
            }
        }
    }
}