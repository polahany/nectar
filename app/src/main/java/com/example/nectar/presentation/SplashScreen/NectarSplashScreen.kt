package com.example.nectar.presentation.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectar.R
import com.example.nectar.presentation.navigation.NavigationDestination
import kotlinx.coroutines.delay
import okio.Timeout

object SplashScreenDestination : NavigationDestination {
    override val route = "splash"
    override val title = "splash"
}

@Composable
fun NectarSplashScreen(
    onTimeout: () -> Unit ,
) {
    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_green)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = "Logo and Typography",
        )
    }
}

@Preview
@Composable
fun NectarSplashScreenPreview(){
    NectarSplashScreen({})
}