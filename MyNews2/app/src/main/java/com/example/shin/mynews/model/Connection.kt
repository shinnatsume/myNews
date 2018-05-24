package com.example.shin.mynews.model



import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableCreate
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

class  Connection {
    companion object {

//        private const val API_KEY   = "7c6d8c349be64838b6b23fc10989e992"
//
//        interface NewsService {
//
//
//            @GET("topstories/v2/home.json?api-key=$API_KEY")
//            fun   getTopstorie(): Observable <List<News>> = Observable.create(
//                    subscriber ->
//            val newsList = mutableListOf<News>()
//            // api call...
//            subscriber.onNext(news)
//            subscriber.onCompleted()
//            )
//        }

   val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nytimes.com/svc/")
            .build()!!


    val newsServiceJson  = retrofit.create(NewsService::class.java)!!
    }
}