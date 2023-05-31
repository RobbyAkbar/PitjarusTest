package com.example.pitjarustest.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pitjarustest.core.designsystem.MyIcons

@Immutable
data class ItemStat(
    val id: Long,
    val name: String,
    val icon: ImageVector,
    val background: Color,
    val value: Int
)

/**
 * Static data
 */

val itemStats = listOf(
    ItemStat(
        id = 1L,
        name = "Total Score",
        value = 150,
        icon = MyIcons.PriorityHigh,
        background = Color(0xFFFF6B6B)
    ),
    ItemStat(
        id = 2L,
        name = "Actual Score",
        value = 150,
        icon = MyIcons.Done,
        background = Color(0xFF51CE66)
    ),
    ItemStat(
        id = 1L,
        name = "Percentage",
        value = 50,
        icon = MyIcons.QueryStats,
        background = Color(0xFFFBC418)
    )
)
