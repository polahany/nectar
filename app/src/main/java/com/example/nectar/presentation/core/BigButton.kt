package com.example.nectar.presentation.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Shapes
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.mainGreen


@Composable
fun BigButton(
    text: String ,
    onClick: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick ,
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = mainGreen,
            contentColor = Color.White
        ),
        modifier = Modifier
            .size(width = 352.dp , height = 68.dp)
    ) {
        Text(
            text = text ,
            style = Typography.labelMedium ,
            fontSize = 18.sp
        )
    }
}


@Preview
@Composable
fun BigButtonPreview(modifier: Modifier = Modifier) {
    BigButton(
        text = "Get Started" ,
        onClick = {} ,
    )
}

