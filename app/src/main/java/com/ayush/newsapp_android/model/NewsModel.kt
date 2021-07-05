package com.ayush.newsapp_android

data class NewsModel (
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)

data class Article (
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class Source (
    val id: String? = null,
    val name: String
)