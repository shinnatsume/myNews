package com.example.shin.mynews.model.connectionAndServices

import com.example.shin.mynews.model.dataClass.ResponceSearch
import com.example.shin.mynews.model.dataClass.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


private const val API_KEY   = "7c6d8c349be64838b6b23fc10989e992"


interface NewsService {


    @GET("topstories/v2/home.json?api-key=$API_KEY")
    fun  getTopStories() : Call<News>

    @GET("mostpopular/v2/mostemailed/all-sections/7.json?api-key=$API_KEY")
    fun getMostPopular() : Call<News>

    @GET("search/v2/articlesearch.json?api-key=$API_KEY")
    fun getArticleSearch(@Query("beginDate") beginDate: String?, @Query("endDate") endDate:String?, @Query("FQ")  FQ :String?, @Query("Q") Q: String?) : Call<ResponceSearch>
}