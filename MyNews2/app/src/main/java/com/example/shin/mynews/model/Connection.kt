package com.example.shin.mynews.model


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Connection {

    companion object {



    private val retrofit =Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    val newsServiceJson  = retrofit.create(NewsService::class.java)
    }
}