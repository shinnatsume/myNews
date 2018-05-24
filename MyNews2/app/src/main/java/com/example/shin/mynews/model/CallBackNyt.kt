package com.example.shin.mynews.model

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import java.lang.ref.WeakReference
import javax.security.auth.callback.Callback

class CallBackNyt {

    internal interface Callbacks {
        fun onResponse(response: News)
        fun onFailure()
    }


    fun fetchNews(callback: Callback, news: News) {
        val callbacksWeakReference = WeakReference(callback)

        val connection = Connection.retrofit.create(Connection::class.java)

        val call = Connection.newsServiceJson.getTopStories()

        call.enqueue(object : retrofit2.Callback<News> {

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
//                Log.i("connect","connect${response?.body()}")
                if(callbacksWeakReference.get()!= null) callbacksWeakReference.get()
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get()

            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.e("t","not connect$t")
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get()
            }


        })

    }
}