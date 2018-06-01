package com.example.shin.mynews.model.connectionAndServices

import com.example.shin.mynews.model.dataClass.News
import retrofit2.Call
import retrofit2.http.GET


private const val API_KEY   = "7c6d8c349be64838b6b23fc10989e992"

const val PARAMS  =""
interface NewsService {


    @GET("topstories/v2/home.json?api-key=$API_KEY")
    fun  getTopStories() : Call<News>

    @GET("mostpopular/v2/mostemailed/all-sections/7.json?api-key=$API_KEY")
    fun getMostPopular() : Call<News>

    @GET("search/v2/articlesearch.json?api-key=$API_KEY&$PARAMS")
    fun getArticleSearch() : Call<News>
}