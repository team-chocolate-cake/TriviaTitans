@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.chocolate.triviatitans.presentation.screens.home

import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.navigateToCategory
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun HomeScreen(navController: NavHostController) {
    TriviaTitansTheme() {
        HomeContent(
            onSelectedMultiChoiceText = { navController.navigateToCategory(1) },
            onSelectedMultiChoiceImage = { navController.navigateToCategory(2) },
            onSelectedWordWise = { navController.navigateToCategory(3) }
        )
    }
}

@Composable
fun HomeContent(
    onSelectedMultiChoiceText: () -> Unit,
    onSelectedMultiChoiceImage: () -> Unit,
    onSelectedWordWise: () -> Unit

) {

    var selectedIndex by rememberSaveable {
        mutableStateOf(-1)
    }
    val configurations = listOf(
        ConfigurationUiState(
            title = stringResource(id = R.string.config_title_card1),
            description = stringResource(id = R.string.config_content_card1),
            image = R.drawable.configuratoin_multi_choice_icon,
            currentIndex = 1,
            index = selectedIndex,
            selected = { i -> selectedIndex = i }
        ),
        ConfigurationUiState(
            title = stringResource(id = R.string.config_title_card2),
            description = stringResource(id = R.string.config_content_card2),
            image = R.drawable.configuratoin_multi_choice_images_icon,
            currentIndex = 2,
            index = selectedIndex,
            selected = { i -> selectedIndex = i }
        ),
        ConfigurationUiState(
            title = stringResource(id = R.string.config_title_card3),
            description = stringResource(id = R.string.config_content_card3),
            image = R.drawable.configuratoin_word_wise_icon,
            currentIndex = 3,
            index = selectedIndex,
            selected = { i -> selectedIndex = i }
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TriviaCustomColors.current.background)
            .padding(16.dp)
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Text(
                    text = stringResource(id = R.string.game_type),
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = TriviaCustomColors.current.onBackground87
                )
            }
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
                                style = MaterialTheme.typography.titleSmall,
                                color = TriviaCustomColors.current.onBackground38
                            )

                            Text(
                                text = stringResource(id = R.string.config_content_card4),
                                maxLines = 3,
                                textAlign = TextAlign.Justify,
                                style = MaterialTheme.typography.titleMedium,
                                color = TriviaCustomColors.current.onBackground87
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
                            Log.e("banan", "Clicked $selectedIndex")
                            val selectedConfiguration = configurations[selectedIndex]
                            val route = when (selectedConfiguration.currentIndex) {
                                1 -> onSelectedMultiChoiceText
                                2 -> onSelectedMultiChoiceImage
                                3 -> onSelectedWordWise
                                else -> ""
                            }
                        },
                        modifier = Modifier
                            .width(250.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 38.dp),
                        colors = ButtonDefaults.buttonColors(TriviaCustomColors.current.primary),

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


