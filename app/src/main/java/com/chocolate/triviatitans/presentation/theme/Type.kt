package com.chocolate.triviatitans.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.R

val firaSansFamily = FontFamily(
    Font(R.font.firasans_regular, FontWeight.Normal),
    Font(R.font.firasans_semibold, FontWeight.SemiBold),
    Font(R.font.firasans_medium, FontWeight.Medium),
    Font(R.font.firasans_bold, FontWeight.Bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 28.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 28.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 14.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 12.sp,
    ),

)