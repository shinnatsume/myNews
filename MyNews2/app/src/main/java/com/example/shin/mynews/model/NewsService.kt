package com.example.shin.mynews.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {


    @GET("topstories/v2/home.json/{apiKey}")
    fun getTopStories(@Path(" apiKey")apiKey:String) : Call <News>
}