package com.example.lettlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

//    h1 = TextStyle(
//        fontSize = 26.sp,
//        fontWeight = FontWeight.Bold,
//        color = charcoal
//    ),
//    h2 = TextStyle(
//        color = charcoal,
//        fontSize = 18.sp,
//        fontWeight = FontWeight.Bold
//    ),
//    body1 = TextStyle(
//        color = green
//    ),
//    body2 = TextStyle(
//        fontWeight = FontWeight.Bold,
//        color = green
//    ),
//    button = TextStyle(
//        fontSize = 14.sp,
//        fontWeight = FontWeight.Bold
//    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)