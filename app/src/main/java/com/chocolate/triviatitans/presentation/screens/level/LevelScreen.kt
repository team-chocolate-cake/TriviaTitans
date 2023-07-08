package com.chocolate.triviatitans.presentation.screens.level

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.ui.screens.level.compose.AppBar
import com.chocolate.triviatitans.ui.screens.level.compose.CardLevels
import com.chocolate.triviatitans.ui.screens.level.compose.DescriptionLevel
import com.chocolate.triviatitans.ui.screens.level.compose.LevelImage
import com.chocolate.triviatitans.ui.screens.level.compose.Score
import com.chocolate.triviatitans.ui.screens.level.compose.StartGameButton
import com.chocolate.triviatitans.view_model.level.LevelUiState
import com.chocolate.triviatitans.view_model.level.LevelViewModel
import com.chocolate.triviatitans.view_model.level.TypeLevel


@Composable
fun LevelScreen(
    navController: NavController,
    viewModel: LevelViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    LevelContent(
        onClickBack = { navController.popBackStack() },
        onClickStartGame = {},
        onLevelSelected = viewModel::updateSelectedLevel,
        state = state,
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelContent(
    onClickBack: () -> Unit,
    onClickStartGame: () -> Unit,
    onLevelSelected: (TypeLevel) -> Unit,
    state: LevelUiState,
) {
    val colors = TriviaCustomColors.current
    val stateScrollable = rememberScrollState()
    Scaffold(
        topBar = { AppBar(onClickBack = onClickBack, color = colors) },
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(Modifier.fillMaxHeight().verticalScroll(state = stateScrollable)) {
            LevelImage()
            Score(state, colors)
            DescriptionLevel(color = colors)
            CardLevels(color = colors, onLevelSelected = onLevelSelected, state = state)
            Spacer(modifier = Modifier.weight(1f))
            StartGameButton(
                color = colors,
                onClickStartGame = onClickStartGame,
            )
        }
    }
}

@Composable
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
fun MyPreview() {
    TriviaTitansTheme() {
        LevelContent(
            onClickBack = {},
            onClickStartGame = {},
            onLevelSelected = {},
            state = LevelUiState(),
        )
    }
}