package com.example.nectar.presentation.orderaccepted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.core.uicomponents.BackButton
import com.example.nectar.core.uicomponents.BigButton
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainBlack
import com.example.nectar.ui.theme.secondaryText

@Composable
fun OrderAcceptedScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.orderacceptedbackground) ,
            contentDescription = "order accepted background" ,
            contentScale = ContentScale.Crop ,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            OrderAcceptedMessage()
            OptionsButtons()
        }
    }
}

@Composable
fun OrderAcceptedMessage(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp, bottom = 120.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.done) ,
            contentDescription = "Done" ,
            modifier = Modifier
                .size(width = 270.dp , height = 240.dp)
        )
        Spacer(Modifier.height(70.dp))
        Text(
            text = stringResource(R.string.your_order_has_been_accepted),
            textAlign = TextAlign.Center ,
            style = Typography.titleMedium ,
            fontSize = 28.sp ,
            lineHeight = 28.sp ,
            color = mainBlack
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.your_items_has_been_placcd_and_is_on_it_s_way_to_being_processed),
            textAlign = TextAlign.Center ,
            style = Typography.bodyLarge ,
            fontSize = 16.sp,
            lineHeight = 21.sp ,
            color = secondaryText ,
        )
    }
}

@Composable
fun OptionsButtons(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        BigButton(
            text = "Track Order" ,
            onClick = {}
        )
        BackButton(
            text = "Back to home" ,
            onClick = {}
        )
    }
}



@Preview
@Composable
fun OrderAcceptedScreenPreview(modifier: Modifier = Modifier) {
    OrderAcceptedScreen()
}