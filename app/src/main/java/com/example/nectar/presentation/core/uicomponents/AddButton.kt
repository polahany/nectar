package com.example.nectar.core.uicomponents

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.mainGreen

@Composable
fun AddButton(
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onAddClick,
        modifier = modifier
            .size(45.dp) ,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = mainGreen ,
            contentColor = Color.White
        ) ,
    ) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "add to cart",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview
@Composable
fun AddVuttonPreview(modifier: Modifier = Modifier) {
    AddButton(
        onAddClick = {}
    )
}