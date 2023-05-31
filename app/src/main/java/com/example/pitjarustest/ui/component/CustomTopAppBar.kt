@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pitjarustest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pitjarustest.R
import com.example.pitjarustest.core.designsystem.MyIcons
import com.example.pitjarustest.ui.theme.PitjarusTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(navController: NavHostController,
                    title: String, subTitle: String? = null,
                    showBackIcon : Boolean, onActionClick: () -> Unit = {},
                    actionIcon: Int? = null) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                )
                if (subTitle != null) {
                    run {
                        Text(
                            text = subTitle,
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }
                }
            }
        },
        navigationIcon = {
            if (showBackIcon && navController.previousBackStackEntry != null) {
                run {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = MyIcons.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            }
        },
        actions = {
            if (actionIcon != null) {
                run {
                    IconButton(onClick = { onActionClick() }) {
                        Image(
                            painterResource(id = actionIcon),
                            contentDescription = "Action",
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    )
}

@Preview("default")
@Composable
private fun ToolbarPreview() {
    PitjarusTestTheme {
        CustomTopAppBar(navController = rememberNavController(),
            title = "List Store", subTitle = "userA", showBackIcon = true,
            actionIcon = R.drawable.book, onActionClick = {

            })
    }
}

@Preview("minim")
@Composable
private fun ToolbarMinimPreview() {
    PitjarusTestTheme {
        CustomTopAppBar(navController = rememberNavController(),
            title = "List Store", showBackIcon = false)
    }
}