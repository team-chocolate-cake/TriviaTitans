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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.presentation.screens.home.GameType
import com.chocolate.triviatitans.presentation.screens.level.viewModel.LevelUiState
import com.chocolate.triviatitans.presentation.screens.level.viewModel.LevelViewModel
import com.chocolate.triviatitans.presentation.screens.level.viewModel.TypeLevel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.navigateToImageGame
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.navigateToTextGame
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.navigateToWordWise
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.customColor
import com.chocolate.triviatitans.ui.screens.level.compose.AppBar
import com.chocolate.triviatitans.ui.screens.level.compose.CardLevels
import com.chocolate.triviatitans.ui.screens.level.compose.DescriptionLevel
import com.chocolate.triviatitans.ui.screens.level.compose.LevelImage
import com.chocolate.triviatitans.ui.screens.level.compose.Score
import com.chocolate.triviatitans.ui.screens.level.compose.StartGameButton

@Composable
fun LevelScreen(
    navController: NavController,
    viewModel: LevelViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    LevelContent(
        onClickBack = { navController.navigateUp() },
        onClickStartGame = {
            val levelType = when (state.selectedLevel) {
                TypeLevel.Easy -> TypeLevel.Easy.name
                TypeLevel.Medium -> TypeLevel.Medium.name
                TypeLevel.Hard -> TypeLevel.Hard.name
            }
            val categories = viewModel.categoriesArgs.toString()
            when (viewModel.gameTypeArgs) {
                GameType.MULTI_CHOICE.name -> navController.navigateToTextGame(
                    categories,
                    levelType
                )

                GameType.MULTI_CHOICE_IMAGES.name -> navController.navigateToImageGame(
                    categories,
                    levelType
                )

                GameType.WORD_WISE.name -> navController.navigateToWordWise(categories, levelType)
            }
        },
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
    val colors = MaterialTheme.customColor()
    val stateScrollable = rememberScrollState()
    Scaffold(
        topBar = { AppBar(onClickBack = onClickBack, color = colors) },
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .verticalScroll(state = stateScrollable)
        ) {
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
    TriviaTitansTheme {
        LevelContent(
            onClickBack = {},
            onClickStartGame = {},
            onLevelSelected = {},
            state = LevelUiState(),
        )
    }
}