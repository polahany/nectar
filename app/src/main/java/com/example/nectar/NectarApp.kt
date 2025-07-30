package com.example.nectar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nectar.core.uicomponents.NavigationBar
import com.example.nectar.presentation.mainpagescreen.MainDestination
import com.example.nectar.presentation.navigation.NectarNavHost
import com.example.nectar.presentation.explorescreen.ExploreDestination


val bottomBarScreens = listOf(
    MainDestination.route,
    ExploreDestination.route,
    "cart"
)

@Composable
fun NectarApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route


    val showBottomBar = currentRoute in bottomBarScreens

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(navController = navController)
            }
        },
        modifier = modifier
    ) {
        paddingValues ->
        NectarNavHost(
            navController = navController,
            modifier = if(showBottomBar) Modifier.padding(bottom = paddingValues.calculateBottomPadding()) else Modifier
        )
    }
}
