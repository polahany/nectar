package com.example.nectar.presentation.onboardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.presentation.core.BigButton
import com.example.nectar.presentation.core.BigButtonPreview
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.onBoardingSmallSlogun

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.onboardpiccroped),
            contentDescription = "onboard background",
            contentScale = ContentScale.Crop
        )
        OnBoardingFrame()
    }
}


@Composable
fun OnBoardingFrame(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(30.dp)
        ){
            OnBoardingContent()
        }
    }
}

@Composable
fun OnBoardingContent(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.splashlogo) ,
        contentDescription = "logo on onboarding" ,
        modifier = Modifier
            .size(width = 49.dp , height = 56.dp)
    )
    Spacer(Modifier.height(36.dp))
    Text(
        text = stringResource(R.string.welcome_to_our_store),
        style = Typography.displayLarge ,
        textAlign = TextAlign.Center ,
        lineHeight = 48.sp ,
        letterSpacing = 0.sp ,
        color = Color.White
    )
    Spacer(Modifier.height(20.dp))
    Text(
        text = stringResource(R.string.get_your_groceries_in_as_fast_as_one_hour) ,
        style = Typography.bodyLarge ,
        color = onBoardingSmallSlogun ,
    )
    Spacer(Modifier.height(40.dp))
    BigButton(
        text = "Get started" ,
        onClick = {} ,
    )
}



@Preview
@Composable
fun OnBoardingScreenPreview(modifier: Modifier = Modifier) {
    OnBoardingScreen()
}