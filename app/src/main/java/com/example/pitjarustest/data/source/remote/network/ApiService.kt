package com.example.pitjarustest.data.source.remote.network

import com.example.pitjarustest.data.source.remote.response.LoggedInUserResponse
import com.example.pitjarustest.utils.MyConfig
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST(MyConfig.LOGIN_URL)
    fun loginAccount(
        @Field("username") id: String,
        @Field("password") password: String
    ): Call<LoggedInUserResponse>

}