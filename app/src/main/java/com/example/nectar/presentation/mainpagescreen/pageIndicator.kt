package com.example.nectar.presentation.mainpagescreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PageIndicator(
    pagerState : PagerState ,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp) ,
        verticalAlignment = Alignment.CenterVertically ,
        modifier = modifier
    ){
        repeat(pagerState.pageCount){
            IndicatorDots(
                isSelected = ( it == pagerState.currentPage ),
            )
        }
    }
}

@Composable
fun IndicatorDots(
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val width by animateDpAsState(
        targetValue = if (isSelected) 16.77.dp else 5.03.dp,
        label = "Dot width"
    )

    val height = 5.38.dp  // constant

    val color by animateColorAsState(
        targetValue = if (isSelected) Color(0xFF53B175) else Color(0xFF030303).copy(alpha = 0.3f),
        label = "Dot color"
    )

    Box(
        modifier = modifier
            .size(width = width, height = height)
            .background(
                color = color,
                shape = RoundedCornerShape(15.dp)
            )
    )
}
