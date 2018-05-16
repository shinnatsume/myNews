package com.example.shin.mynews.model

import com.google.gson.annotations.SerializedName


data class News(
       @SerializedName("results") val results : MutableList<Results>
        )
