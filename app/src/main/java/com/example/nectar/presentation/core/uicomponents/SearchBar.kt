package com.example.nectar.core.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.room.util.query
import com.example.nectar.R
import com.example.nectar.ui.theme.Typography
import com.example.nectar.ui.theme.searchBar
import com.example.nectar.ui.theme.secondaryText

@Composable
fun SearchBar(
    query: String ,
    onSearchQueryChange: (String) -> Unit = {},
    onCancel: () -> Unit = {},
    onClick: () -> Unit = {} ,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onSearchQueryChange,
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
            .onFocusChanged{
                focusState ->
                if (focusState.isFocused){
                    onClick()
                }
            },

        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(
                    onClick = onCancel
                ) {
                    Icon(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = "Cancel Icon",
                        modifier = Modifier
                            .size(width = 18.dp, height = 18.dp)
                    )
                }
            }
        }

    )
}

@Preview
@Composable
fun SearchBarPreview(modifier: Modifier = Modifier) {
    SearchBar(
        query = "" ,
        onSearchQueryChange = { }  ,
    )
}
