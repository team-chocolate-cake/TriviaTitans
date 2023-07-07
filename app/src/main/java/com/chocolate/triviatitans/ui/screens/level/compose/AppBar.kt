package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.CustomColorsPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onClickBack: () -> Unit, color: CustomColorsPalette) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.choose_level),
                color = color.onBackground87,
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            IconButton(onClick = onClickBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Bake Icon",
                    tint = color.onBackground87
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(color.background),
    )
}