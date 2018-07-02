package com.example.shin.mynews.model.dataClass

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class News (
        @SerializedName("results") val results : MutableList<Results>

): Serializable
