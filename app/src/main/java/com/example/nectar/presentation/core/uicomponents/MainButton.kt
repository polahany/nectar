package com.example.nectar.core.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Shapes
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainGreen


@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    totalPrice: Double = 0.0,
    isTotalPriceVisible: Boolean = false,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = mainGreen,
            contentColor = Color.White
        ),
        modifier = modifier
            .size(width = 352.dp, height = 68.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = text,
                style = Typography.labelMedium,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )

            if (isTotalPriceVisible) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .background(Color(0xFF489E67), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "$${"%.2f".format(totalPrice)}",
                        style = Typography.bodySmall,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}




@Preview
@Composable
fun BigButtonPreview(modifier: Modifier = Modifier) {
    MainButton(
        text = "Get Started" ,
        onClick = {} ,
        isTotalPriceVisible = true ,
    )
}

