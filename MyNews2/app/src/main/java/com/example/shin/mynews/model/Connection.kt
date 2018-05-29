package com.example.shin.mynews.model



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class  Connection {

    companion object {

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.nytimes.com/svc/")
                .build()!!

        val newsServiceJson  = retrofit.create(NewsService::class.java)!!
    }

}