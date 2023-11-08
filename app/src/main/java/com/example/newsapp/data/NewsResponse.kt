package com.example.newsapp.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "totalResults")
    val totalResults: Int? = null,

    @Json(name = "articles")
    var articles: List<ArticlesItem>? = null,
)

@JsonClass(generateAdapter = true)

data class ArticlesItem(
    @Json(name = "publishedAT")
    val publishedAt: String? = null
)
