package com.example.pitjarustest.model

import androidx.compose.runtime.Immutable

@Immutable
data class User(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val role: String,
    val nik: String,
)

/**
 * Static data
 */

val users = listOf(
    User(
        id = 1L,
        name = "Mitha Khairulnisa",
        imageUrl = "https://source.unsplash.com/rDEOVtE7vOs",
        role = "Manager",
        nik = "3236051123991115"
    ),
    User(
        id = 2L,
        name = "Robby Akbar",
        imageUrl = "https://source.unsplash.com/c_GmwfHBDzk",
        role = "Checker",
        nik = "1239911153236051"
    ),
    User(
        id = 3L,
        name = "Rabka Ibbor",
        imageUrl = "https://source.unsplash.com/jmURdhtm7Ng",
        role = "Staff",
        nik = "3211239911153605"
    )
)
