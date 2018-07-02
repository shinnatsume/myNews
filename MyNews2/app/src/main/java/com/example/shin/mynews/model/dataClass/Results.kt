package com.example.shin.mynews.model.dataClass

import com.example.shin.mynews.model.dataClass.Media
import com.example.shin.mynews.model.dataClass.Multimedia
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
        @SerializedName("section")  val section : String,
        @SerializedName("subsection") val subsection : String,
        @SerializedName("title") val title : String,
        @SerializedName("url") val urlArticle : String,
        @SerializedName("byline") val byline : String,
        @SerializedName("updated_date") val updateDate :String,
        @SerializedName("published_date") val publishedDate : String,
        @SerializedName("multimedia") val multimedia:  MutableList<Multimedia>,
        @SerializedName("media") val media: MutableList<Media>

): Serializable