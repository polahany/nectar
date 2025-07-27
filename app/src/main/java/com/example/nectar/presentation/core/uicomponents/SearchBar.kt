package com.example.nectar.core.uicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.searchBar
import com.example.nectar.ui.theme.secondaryText

@Composable
fun SearchBar(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = onValueChange,
        placeholder = {
            Text(text = "Search Store",
                color = secondaryText ,
                style = Typography.labelMedium ,
                fontSize = 14.sp ,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .size(width = 18.dp , height = 18.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = searchBar,
            unfocusedContainerColor = searchBar,
            disabledContainerColor = searchBar,
            focusedIndicatorColor = searchBar,
            unfocusedIndicatorColor = searchBar,
            disabledIndicatorColor = searchBar
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    )
}

@Preview
@Composable
fun SearchBarPreview(modifier: Modifier = Modifier) {
    SearchBar(
        onValueChange = {}
    )
}
