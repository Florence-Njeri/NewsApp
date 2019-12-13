package com.example.newsapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.constants.AppConstants
import com.example.newsapp.data.NewsResponse
import com.example.newsapp.data.NewsResults
import com.example.newsapp.network.NetworkClient
import com.example.newsapp.network.NetworkClientApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val api: NetworkClientApi):BaseRepository() {
    /*
     * method to fetch news
     * */

    suspend fun fetchNews(): MutableList<NewsResults>? {

        //safeApiCall is defined in BaseRepository.kt
        val movieResponse = safeApiCall(
            call = {api.getNewsAsync().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results?.toMutableList()
//        val data = MutableLiveData<NewsResults>()
//        NetworkClient.theGuardianApi.getNewsAsync().enqueue(object : Callback<List<NewsResults>> {
//            override fun onFailure(call: Call<List<NewsResults>>, t: Throwable) {
//                println(t.message)
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call<List<NewsResults>>, response: Response<List<NewsResults>>) {
//                println("Sucess : ${response.body()?.size}")
////                data.value = response.body().size
////                if (response != null && response.!= null) {
////                    callback.onSuccess(moviesResponse.getMovies());
////                } else {
////                    callback.onError();
////                }
//            }
//        })
//
//        return data
    }



}





