package com.example.nectar.core.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.presentation.cartscreen.CartDestination
import com.example.nectar.presentation.explorescreen.ExploreDestination
import com.example.nectar.presentation.mainpagescreen.MainDestination
import com.example.nectar.presentation.searchscreen.SearchDestination
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.mainGreen


val screens = listOf(
    MainDestination.route ,
    ExploreDestination.route ,
    CartDestination.route ,
)

val icons = listOf(
    R.drawable.marketvectorsvg ,
    R.drawable.exploresvg ,
    R.drawable.cartsvg ,
)
@Composable
fun NavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .height(92.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .background(Color.White)
    ) {
        screens.forEachIndexed { index, screen ->
            NavigationIcon(
                isSelected = currentRoute == screen ||
                        (screen == ExploreDestination.route && currentRoute == SearchDestination.route),
                icon = icons[index],
                onClick = {
                    if (currentRoute != screen) {
                        navController.navigate(screen) {
                            popUpTo(MainDestination.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}


@Composable
fun NavigationIcon(
    isSelected: Boolean,
    icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        tint = if (isSelected) mainGreen else mainBlack,
        modifier = modifier
            .size(36.dp)
            .clickable { onClick() }
    )
}


@Preview
@Composable
fun NavigationBarPreview(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavigationBar(navController)
}