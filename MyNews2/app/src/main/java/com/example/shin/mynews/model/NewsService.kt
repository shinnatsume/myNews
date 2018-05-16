package com.example.shin.mynews.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

private const val API_KEY   = "7c6d8c349be64838b6b23fc10989e992"

interface NewsService {


    @GET("topstories/v2/home.json?api-key=$API_KEY")
    fun  getTopStories() : Call<News>
}