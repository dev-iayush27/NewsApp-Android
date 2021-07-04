package com.ayush.newsapp_android

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("top-headlines")
    fun getHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): retrofit2.Call<News>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2"
    }
}