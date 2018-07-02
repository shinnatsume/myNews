package com.example.shin.mynews.model.dataClass


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Multimedia(
                @SerializedName("url")  val url : String
): Serializable


