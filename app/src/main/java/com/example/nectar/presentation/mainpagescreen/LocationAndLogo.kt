package com.example.nectar.presentation.mainpagescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.HomeScreenLocation
import com.example.nectar.ui.theme.Typography

@Composable
fun LogoAndLocation(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.colouredlogo) ,
            contentDescription = "coloured logo" ,
            modifier = Modifier
                .size(width = 28.dp , height = 30.dp) ,
        )
        Spacer(Modifier.height(8.dp))
        Location(text = "Dhaka, Banassre")
    }
}

@Composable
fun Location(
    text: String ,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.Center ,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.location) ,
            contentDescription = "location icon" ,
            modifier = Modifier
                .size(width = 15.dp , height = 18.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = text ,
            style = Typography.labelMedium ,
            fontSize = 18.sp ,
            color = HomeScreenLocation
        )
    }
}