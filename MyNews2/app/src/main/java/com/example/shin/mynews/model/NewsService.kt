package com.example.shin.mynews.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {

//   private val API_KEY  :String = "7c6d8c349be64838b6b23fc10989e992"

    @GET("topstories/v2/home.json?api-key=7c6d8c349be64838b6b23fc10989e992")
    fun getTopStories() : Call <News>
}