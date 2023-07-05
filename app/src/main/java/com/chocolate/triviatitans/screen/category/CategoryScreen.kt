package com.chocolate.triviatitans.screen.category

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composable.CategoryCard
import com.chocolate.triviatitans.ui.theme.TriviaCustomColors
import com.chocolate.triviatitans.ui.theme.Typography


@Composable
fun CategoryScreen() {
    val categories = listOf(
        "Geography",
        "Music",
        "Sport and leisure",
        "Movie and Tv",
        "Arts and literature",
        "History",
        "Society and culture",
        "Science",
        "General Knowledge",
        "Food And Drink"
    )

    CategoryContent(categories)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryContent(categories: List<String>) {
    val colors = TriviaCustomColors.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor =colors.background,
        topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colors.background),
            title = { Text(text = "You want to improve today?",style = MaterialTheme.typography.titleMedium, color = colors.onBackground87) },
            navigationIcon = {
                IconButton(onClick = {/*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back" ,tint = colors.onBackground87)
                }
            }
        )
    },
        bottomBar = {
            Surface(modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(),
                color =colors.card,
                shadowElevation = 20.dp,
                tonalElevation = 20.dp,
                shape = RoundedCornerShape(topStart = 24.dp , topEnd = 24.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp) , horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Total select",style = MaterialTheme.typography.titleMedium,fontSize = 12.sp, color = colors.onBackground60)
                        Text(text = "3",style = MaterialTheme.typography.titleMedium,fontSize = 16.sp, color = colors.onBackground87)
                    }
                    Button(onClick = { } , contentPadding = PaddingValues(horizontal =60.dp), colors = ButtonDefaults.buttonColors(containerColor = colors.primary)) {
                        Text(text = "Next",style = MaterialTheme.typography.titleMedium,fontSize = 14.sp, color = Color.White)
                    }
                }
            }
        }
    )
    {padding->
        LazyVerticalGrid(
            contentPadding = PaddingValues(top = padding.calculateTopPadding() , bottom = padding.calculateBottomPadding() , start = 16.dp , end = 16.dp) ,
            columns = GridCells.Fixed(count = 2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = categories
            ) { category ->
                CategoryCard(category = category)
            }
        }
    }




}

@Preview()
@Composable
fun CategoryScreenPreview() {
    CategoryScreen()
}