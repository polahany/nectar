package com.example.nectar.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nectar.R

val Aclonica = FontFamily(
    Font(R.font.aclonica_regular)
)

val AirBnbCereal = FontFamily(
    Font(R.font.airbnbcereal_w_med)
)

val Gilory = FontFamily(
    Font(R.font.gilroy_regular),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_bold, FontWeight.Bold),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold)
)

val Typography = Typography(

    labelLarge = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 5.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.sp
    ),

    titleMedium = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),

    titleSmall = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = Aclonica,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = AirBnbCereal,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),

    displayMedium = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),

    bodySmall = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),

    labelMedium = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),

    headlineSmall = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),

    displaySmall = TextStyle(
        fontFamily = Gilory,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    )
)
