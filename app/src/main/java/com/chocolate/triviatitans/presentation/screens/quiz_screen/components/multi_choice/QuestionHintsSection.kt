package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice.MultiChoiceTextUiState
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun QuestionHintsSection(
    hintListener: HintListener,
    fiftyFiftyHint: MultiChoiceTextUiState.HintButton,
    heartHint: MultiChoiceTextUiState.HintButton,
    resetHint: MultiChoiceTextUiState.HintButton,
    correctAnswer: String,
) {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        HintAlertDialog(onDissmiss = { showDialog.value = false }, correctAnswer = correctAnswer)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        QuestionHint(
            icon = R.drawable.ic_50_50,
            numberOfTries = fiftyFiftyHint.numberOfTries,
            imageModifier = Modifier.padding(16.dp),
            onClick = { if (fiftyFiftyHint.isActive) hintListener.onClickFiftyFifty() }
        )
        QuestionHint(
            icon = R.drawable.ic_heart,
            numberOfTries = heartHint.numberOfTries,
            imageModifier = Modifier.padding(20.dp),
            onClick = {
                if (heartHint.isActive) hintListener.onClickHeart()
                showDialog.value = true
            }
        )
        QuestionHint(
            icon = R.drawable.ic_restart,
            numberOfTries = resetHint.numberOfTries,
            imageModifier = Modifier.padding(20.dp),
            onClick = { if (resetHint.isActive) hintListener.onClickReset() }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuestionHintsSectionPreview() {
    TriviaTitansTheme() {
        QuestionHintsSection(
            hintListener = object : HintListener {
                override fun onClickFiftyFifty() {
                    TODO("Not yet implemented")
                }

                override fun onClickHeart() {
                    TODO("Not yet implemented")
                }

                override fun onClickReset() {
                    TODO("Not yet implemented")
                }
            },
            MultiChoiceTextUiState.HintButton(),
            MultiChoiceTextUiState.HintButton(),
            MultiChoiceTextUiState.HintButton(), correctAnswer = ""
        )
    }
}