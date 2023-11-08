package com.example.newsapp.data.network

import com.example.newsapp.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/everything")
    fun getCommonNews(
        @Query("q") q: String = "islam",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 50,
        @Query("sortBy") sortBy : String = "popularity"
    ):Call<NewsResponse>
}