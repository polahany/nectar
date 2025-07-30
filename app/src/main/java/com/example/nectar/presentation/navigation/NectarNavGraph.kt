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
import com.example.nectar.presentation.cartscreen.CartDestination
import com.example.nectar.presentation.cartscreen.CartScreen
import com.example.nectar.presentation.categoryscreen.CategoryDestination
import com.example.nectar.presentation.categoryscreen.CategoryScreen
import com.example.nectar.presentation.mainpagescreen.MainPage
import com.example.nectar.presentation.mainpagescreen.MainDestination
import com.example.nectar.presentation.onboardingscreen.OnBoardingDestination
import com.example.nectar.presentation.onboardingscreen.OnBoardingScreen
import com.example.nectar.presentation.productdetailscreen.ProductDetailDestination
import com.example.nectar.presentation.productdetailscreen.ProductDetailScreen
import com.example.nectar.presentation.explorescreen.ExploreDestination
import com.example.nectar.presentation.explorescreen.ExploreProductScreen
import com.example.nectar.presentation.orderaccepted.OrderAcceptedDestination
import com.example.nectar.presentation.orderaccepted.OrderAcceptedScreen

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
                onCategoryClick = {
                    category ->
                    navController.navigate(
                        "${CategoryDestination.route}/$category"
                    )
                }
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
            route = ExploreDestination.route
        ) {
            ExploreProductScreen(
                onCategoryClick = {
                    category ->
                    navController.navigate(
                        "${CategoryDestination.route}/$category"
                    )
                }
            )
        }

        composable (
            route = CategoryDestination.routeWithArgs ,
            arguments = listOf(
                navArgument(
                    name = CategoryDestination.categoryArg
                ){
                    type = NavType.StringType
                }
            )
        ){
            backStackEntry ->
            val category = backStackEntry.arguments?.getString(CategoryDestination.categoryArg) ?: ""
            CategoryScreen(
                category = category ,
                onBack = { navController.navigateUp() } ,
                onCardClick = {
                        product ->
                    navController.navigate(
                        "${ProductDetailDestination.route}/${product.id}"
                    )
                }
            )
        }

        composable(
            route = CartDestination.route
        ) {
            CartScreen(
                navigateToOrderCheckout = {
                    navController.navigate(
                        OrderAcceptedDestination.route
                    )
                }
            )
        }

        composable(
            route = OrderAcceptedDestination.route
        ) {
            OrderAcceptedScreen(
                onBackToHome = {
                    navController.navigate(MainDestination.route) {
                        popUpTo(OrderAcceptedDestination.route) {inclusive = true}
                    }
                }
            )
        }
    }
}