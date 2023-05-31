package com.example.pitjarustest.data.source.remote.response

import com.example.pitjarustest.model.StoreItem

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUserResponse(
    val status: Boolean,
    val message: String,
    val stores: List<StoreItem>
)