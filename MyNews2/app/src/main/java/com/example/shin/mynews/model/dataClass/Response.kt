package com.example.shin.mynews.model.dataClass
import com.google.gson.annotations.SerializedName
data class Response(@SerializedName("docs")  val docs :List<Doc>)