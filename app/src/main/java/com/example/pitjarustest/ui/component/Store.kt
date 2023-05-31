package com.example.pitjarustest.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
private fun ItemStore(
    store: Store,
    onClickActor: (Int) -> Unit,
    closeKeyboard: () -> Unit?
) {
    Text(
        text = store.actorName,
        style = MaterialTheme.typography.h6,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                closeKeyboard()
                onClickActor(store.actorId)
            }
            .padding(horizontal = 20.dp, vertical = 12.dp)
            .wrapContentWidth(Alignment.Start)
    )
}