package com.mad.cardviewui

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
