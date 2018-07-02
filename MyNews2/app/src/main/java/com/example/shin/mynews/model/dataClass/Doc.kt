package com.example.shin.mynews.model.dataClass

import com.google.gson.annotations.SerializedName

data class Doc (
                        @SerializedName("web_url") val urlArticle: String,
                        @SerializedName("snippet") val snippet:  String
)