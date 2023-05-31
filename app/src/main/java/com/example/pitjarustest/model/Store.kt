package com.example.pitjarustest.model

import androidx.compose.runtime.Immutable

@Immutable
data class StoreItem(
    val store_id: Int,
    val store_code: String,
    val store_name: String,
    val address: String,
    val dc_name: String,
    val account_name: String,
    val subchannel_name: String,
    val channel_name: String,
    val area_name: String,
    val region_name: String,
    val latitude: Float,
    val longitude: Float
)
