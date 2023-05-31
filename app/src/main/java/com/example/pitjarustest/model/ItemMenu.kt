package com.example.pitjarustest.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.example.pitjarustest.R

@Immutable
data class ItemMenu(
    val id: Long,
    val name: String,
    val icon: Int,
    val background: Color,
)

/**
 * Static data
 */

val itemMenus = listOf(
    ItemMenu(
        id = 1L,
        name = "Kunjungan",
        icon = R.drawable.store,
        background = Color(0xFFE4ECFF)
    ),
    ItemMenu(
        id = 2L,
        name = "Target Install CDFDPC",
        icon = R.drawable.target,
        background = Color(0xFFE4ECFF)
    ),
    ItemMenu(
        id = 3L,
        name = "Dashboard",
        icon = R.drawable.dashboard,
        background = Color(0xFFE4ECFF)
    ),
    ItemMenu(
        id = 4L,
        name = "Transmission History",
        icon = R.drawable.book,
        background = Color(0xFFE4ECFF)
    ),
    ItemMenu(
        id = 5L,
        name = "Logout",
        icon = R.drawable.arrow,
        background = Color(0xFFE4ECFF)
    )
)
