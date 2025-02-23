package com.mad.cardviewui

import retrofit2.Call
import retrofit2.http.GET


interface NewsApiService {
    @GET("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=95b6ba6570c049be9c2e77e9dbbdb072")
    fun getNews(): Call<NewsResponse>
}