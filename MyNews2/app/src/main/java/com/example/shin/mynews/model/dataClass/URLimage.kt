package com.example.shin.mynews.model.dataClass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class URLimage(
    @SerializedName("url")  val urlImage : String): Serializable