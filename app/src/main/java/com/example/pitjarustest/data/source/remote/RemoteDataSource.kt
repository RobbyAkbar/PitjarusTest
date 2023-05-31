package com.example.pitjarustest.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pitjarustest.data.source.remote.network.ApiService
import com.example.pitjarustest.data.source.remote.network.Result
import com.example.pitjarustest.data.source.remote.response.LoggedInUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class RemoteDataSource(private val apiService: ApiService) {

    companion object {
        private val TAG: String = RemoteDataSource::class.java.simpleName
    }

    fun login(username: String, password: String): LiveData<Result<LoggedInUserResponse>> {
        val client = apiService.loginAccount(username, password)
        val resultData = MutableLiveData<Result<LoggedInUserResponse>>()

        client.enqueue(object : Callback<LoggedInUserResponse> {
            override fun onResponse(
                call: Call<LoggedInUserResponse>,
                response: Response<LoggedInUserResponse>
            ) {
                val data = response.body()
                resultData.value =
                    if (data != null) Result.Success(data) else Result.Empty
            }

            override fun onFailure(call: Call<LoggedInUserResponse>, t: Throwable) {
                resultData.value = Result.Error(IOException("Error logging in", t))
            }
        })
        return resultData
    }

}