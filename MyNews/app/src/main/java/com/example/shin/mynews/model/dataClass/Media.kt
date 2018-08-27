package com.example.shin.mynews.model.dataClass

import com.google.gson.annotations.SerializedName

data class Media(
        @SerializedName("media-metadata") val mediaImage: MutableList<URLimage>
)