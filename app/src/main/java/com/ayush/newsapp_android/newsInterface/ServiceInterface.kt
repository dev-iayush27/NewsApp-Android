package com.ayush.newsapp_android.newsInterface

import com.ayush.newsapp_android.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): retrofit2.Call<NewsModel>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }
}