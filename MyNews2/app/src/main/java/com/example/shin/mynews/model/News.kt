package com.example.shin.mynews.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url


data class News(
        val section : String,
        val subsection : String,
        val title : String,
        val urlArticle : Url,
        val byline : String,
        @SerializedName("update_date") val updateDate :String,
        val mutimedia :Url
        )
