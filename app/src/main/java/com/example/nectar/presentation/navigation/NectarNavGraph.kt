package com.example.nectar.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nectar.presentation.SplashScreen.NectarSplashScreen
import com.example.nectar.presentation.SplashScreen.SplashScreenDestination
import com.example.nectar.presentation.mainpagescreen.MainPage
import com.example.nectar.presentation.mainpagescreen.MainDestination
import com.example.nectar.presentation.onboardingscreen.OnBoardingDestination
import com.example.nectar.presentation.onboardingscreen.OnBoardingScreen
import com.example.nectar.presentation.productdetailscreen.ProductDetailDestination
import com.example.nectar.presentation.productdetailscreen.ProductDetailScreen
import com.example.nectar.presentation.searchscreen.FindDestination
import com.example.nectar.presentation.searchscreen.FindProductScreen

@Composable
fun NectarNavHost(
    navController: NavHostController ,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController ,
        startDestination = SplashScreenDestination.route ,
        modifier = modifier
    ){
        composable(
            route = SplashScreenDestination.route
        ) {
            NectarSplashScreen(
                onTimeout = {
                    navController.navigate(OnBoardingDestination.route) {
                        popUpTo(SplashScreenDestination.route) {inclusive = true}
                    }
                }
            )
        }
        composable (
            route = OnBoardingDestination.route
        ){
            OnBoardingScreen(
                onButtonClicked = {
                    navController.navigate(MainDestination.route) {
                        popUpTo(OnBoardingDestination.route) {inclusive = true}
                    }
                }
            )
        }
        composable (
            route = MainDestination.route
        ){
            MainPage(
                onCardClick = {
                    product ->
                    navController.navigate(
                        "${ProductDetailDestination.route}/${product.id}"
                    )
                } ,
            )
        }

        composable(
            route = ProductDetailDestination.routeWithArgs ,
            arguments = listOf(
                navArgument(
                    name = ProductDetailDestination.productArg
                ){
                    type = NavType.IntType
                }
            )
        ) {
            backStackEntry ->
            val productId = backStackEntry.arguments?.getInt(ProductDetailDestination.productArg) ?: -1
            ProductDetailScreen(
                productId = productId ,
                onBack = {navController.navigateUp()}
            )
        }

        composable(
            route = FindDestination.route
        ) {
            FindProductScreen()
        }
    }
}