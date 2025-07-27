package com.example.nectar.core.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen


val screens = listOf(
    "main" ,
    "explore" ,
    "cart"
)
val currentScreen= "main"

val icons = listOf(
    R.drawable.marketvectorsvg ,
    R.drawable.exploresvg ,
    R.drawable.cartsvg ,
)
@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround ,
        modifier = modifier
            .height(92.dp)
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .background(Color.White)
    ) {
        repeat(screens.size){
            page ->
            NavigationIcon(
                isSelected = currentScreen == screens[page] ,
                icon = icons[page]
            )
        }
    }
}

@Composable
fun NavigationIcon(
    isSelected: Boolean,
    icon: Int ,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        tint = if (isSelected) mainGreen else mainBlack,
        modifier = modifier
            .size(32.dp)
    )
}


@Preview
@Composable
fun NavigationBarPreview(modifier: Modifier = Modifier) {
    NavigationBar()
}