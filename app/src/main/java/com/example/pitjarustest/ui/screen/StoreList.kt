package com.example.pitjarustest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pitjarustest.R
import com.example.pitjarustest.core.designsystem.MyIcons
import com.example.pitjarustest.ui.component.CustomTopAppBar
import com.example.pitjarustest.ui.theme.PitjarusTestTheme

@Composable
fun StoreList(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxHeight(1f)
    ) {
        var query: String by rememberSaveable { mutableStateOf("") }
        var showClearIcon by rememberSaveable { mutableStateOf(false) }

        if (query.isEmpty()) {
            showClearIcon = false
        } else if (query.isNotEmpty()) {
            showClearIcon = true
        }

        if (query.isEmpty()) {
            showClearIcon = false
        } else if (query.isNotEmpty()) {
            showClearIcon = true
        }

        CustomTopAppBar(navController = navController,
            title = "List Store", subTitle = "userA", showBackIcon = true,
            actionIcon = R.drawable.book, onActionClick = {
                //TODO
            })
        OutlinedTextField(
            value = query,
            onValueChange = { onQueryChanged ->
                // If user makes changes to text, immediately updated it.
                query = onQueryChanged
                // To avoid crash, only query when string isn't empty.
                if (onQueryChanged.isNotEmpty()) {
                    // Pass latest query to refresh search results.
                    //viewModel.performQuery(onQueryChanged)
                }
            },
            leadingIcon = {
                Icon(
                    imageVector = MyIcons.Search,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (showClearIcon) {
                    IconButton(onClick = { query = "" }) {
                        Icon(
                            imageVector = MyIcons.Clear,
                            tint = MaterialTheme.colors.onBackground,
                            contentDescription = "Clear Icon"
                        )
                    }
                }
            },
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            placeholder = { Text(text = stringResource(R.string.hint_search_query)) },
            textStyle = MaterialTheme.typography.subtitle1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.padding(8.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background, shape = RectangleShape)
        )
    }
}

@Preview("default", showBackground = true)
@Composable
fun StoreListPreview() {
    PitjarusTestTheme {
        StoreList(navController = rememberNavController())
    }
}
