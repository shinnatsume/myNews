package com.example.shin.mynews.model

import com.google.gson.annotations.SerializedName

data class Results(
        @SerializedName("section")  val section : String,
        @SerializedName("subsection") val subsection : String,
        @SerializedName("title") val title : String,
        @SerializedName("url") val urlArticle : String,
        @SerializedName("byline") val byline : String,
        @SerializedName("updated_date") val updateDate :String
)