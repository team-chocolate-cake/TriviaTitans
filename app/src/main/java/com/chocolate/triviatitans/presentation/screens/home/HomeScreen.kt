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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.category.navigateToCategory
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    TriviaTitansTheme {
        HomeContent(
            state = state,
            onGameTypeChanged = viewModel::changeSelectedGameType,
            onNextScreenClick = { selectedGame ->
                navController.navigateToCategory(selectedGame)
            }
        )
    }
}

@Composable
fun HomeContent(
    state: HomeUiState,
    onGameTypeChanged:(GameType)->Unit,
    onNextScreenClick: (GameType) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TriviaCustomColors.current.background)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.game_type),
            modifier = Modifier.padding(top = 24.dp),
            style = MaterialTheme.typography.titleMedium,
            color = TriviaCustomColors.current.onBackground87,
            textAlign = TextAlign.Start
        )
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(state.homeCards) { homeCard ->
                ConfigurationCard(
                    gameType = homeCard.gameType,
                    typeDescription = homeCard.description,
                    typeImage = homeCard.image,
                    selectedGameType = state.selectedGameType,
                    onSelect = onGameTypeChanged
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
                if (state.selectedGameType != null) {
                    Button(
                        onClick = {
                            onNextScreenClick(state.selectedGameType)
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