package com.chocolate.triviatitans.screen.category.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.ui.theme.TriviaCustomColors
import com.chocolate.triviatitans.ui.theme.TriviaTitansTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onBackClick: () -> Unit = {}
) {
    val colors = TriviaCustomColors.current

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(colors.background),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = colors.onBackground87
            )
        },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back",
                    tint = colors.onBackground87
                )
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TriviaTitansTheme {
        TopBar(title = "Category")
    }
}