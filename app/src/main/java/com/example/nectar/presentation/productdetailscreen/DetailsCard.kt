package com.example.nectar.presentation.productdetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nectar.R
import com.example.nectar.data.mockdata.mockitem
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.itemBackGround
import com.example.nectar.ui.theme.mainBlack

@Composable
fun DetailsCard(
    product: Product ,
    onBack: () -> Unit ,
    onDownload: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(370.dp)
            .clip(RoundedCornerShape(bottomStart =  25.dp , bottomEnd = 25.dp))
            .background(itemBackGround)
            .padding(top = 56.dp) ,
    ) {
        DetailsCardButtons(
            onDownload = onDownload ,
            onBack = onBack
        )
        Spacer(Modifier.height(28.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.image_url)
                .crossfade(true)
                .build(),
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(328.dp, 200.dp)
        )
    }
}

@Composable
fun DetailsCardButtons(
    onDownload: () -> Unit ,
    onBack: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)
    ){
        IconButton(
            onClick = onBack
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft ,
                contentDescription = "back from details" ,
                modifier = Modifier
                    .size(height = 36.dp , width = 20.dp)
            )
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = onDownload ,
            colors = ButtonDefaults.buttonColors(
                containerColor = itemBackGround,
                contentColor = mainBlack
            )
            ) {
            Image(
                painter = painterResource(R.drawable.upload),
                contentDescription = "download from details" ,
                modifier = Modifier
                    .size(height = 36.dp , width = 20.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsCardPreview(modifier: Modifier = Modifier) {

    DetailsCard(
        product = mockitem ,
        onBack = {} ,
        onDownload = {}
    )

}