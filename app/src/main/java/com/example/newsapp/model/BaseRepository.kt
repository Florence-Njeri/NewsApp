package com.example.newsapp.model

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseRepository{

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {

        val result : Results<T> = safeApiResult(call,errorMessage)
        var data : T? = null

        when(result) {
            is Results.Success ->
                data = result.data
            is Results.Error -> {
                Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
            }
        }


        return data

    }

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>, errorMessage: String) : Results<T>{
        val response = call.invoke()
        if(response.isSuccessful) return Results.Success(response.body()!!)

        return Results.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}