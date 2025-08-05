package com.example.nectar.presentation.mainpagescreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainGreen
import kotlinx.coroutines.delay


@Composable
fun Adverstisment(modifier: Modifier = Modifier) {
    val advertismentsOffers = listOf<Int>(
        R.drawable.offer1 ,
        R.drawable.offer1 ,
        R.drawable.offer1 ,
    )

    val advertismentsMasks = listOf<Int>(
        R.drawable.mask1 ,
        R.drawable.mask1 ,
        R.drawable.mask1 ,
    )

    val advertismentsBackGround = listOf<Int>(
        R.drawable.blurred_ad_background ,
        R.drawable.blurred_ad_background ,
        R.drawable.blurred_ad_background ,
    )

    val advertismentsOffersNames = listOf<String>(
        "Fresh Vegetables" ,
        "Fresh Meat" ,
        "Fresh Oil" ,
    )

    val advertismentsOffersPercentage = listOf<String>(
        "Get Up To 40% OFF" ,
        "Get Up To 40% OFF" ,
        "Get Up To 40% OFF" ,
    )


    val pagerState = rememberPagerState(pageCount = { advertismentsOffers.size })

    LaunchedEffect(Unit) {
        while (true){
            delay(3000)
            if (!pagerState.isScrollInProgress) {
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(durationMillis = 600)
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .size(width = 378.dp , height = 115.dp)
    ) {
        HorizontalPager(
            state = pagerState
        ) {
                currentpage ->
            advertismentCard(
                advetismentMask = advertismentsMasks[currentpage],
                advertismentOffer = advertismentsOffers[currentpage],
                advertismentBackGround = advertismentsBackGround[currentpage],
                offerName = advertismentsOffersNames[currentpage],
                offerPercentage = advertismentsOffersPercentage[currentpage] ,
            )
        }
        PageIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }

}

@Composable
fun advertismentCard(
    advetismentMask : Int ,
    advertismentOffer : Int ,
    advertismentBackGround : Int ,
    offerName: String ,
    offerPercentage: String ,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Box {
            Image(
                painter = painterResource(advertismentBackGround) ,
                contentDescription = "advertisment backGround" ,
                contentScale = ContentScale.Crop ,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(24.dp)
            )
            Image(
                painter = painterResource(advetismentMask) ,
                contentDescription = "advertisment mask" ,
                contentScale = ContentScale.Crop ,
                modifier = Modifier
                    .fillMaxSize()
            )
            Image(
                painter = painterResource(advertismentOffer) ,
                contentDescription = "advertisment offer" ,
                contentScale = ContentScale.Crop ,
                modifier = Modifier
                    .size(width = 122.dp , height = 105.dp ) ,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally ,
                modifier = Modifier
                    .padding(start = 130.dp, top = 40.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = offerName ,
                    style = Typography.headlineMedium ,
                )
                Text(
                    text = offerPercentage ,
                    style = Typography.bodyMedium ,
                    color = mainGreen ,
                )
            }

        }
    }
}



@Preview
@Composable
fun AdPreview(modifier: Modifier = Modifier) {
    Adverstisment()
}