package com.example.shin.mynews.model.Utils

import android.content.Context
import android.content.SharedPreferences

class Load(context: Context) {



    var mPref : SharedPreferences = context.getSharedPreferences("save",0)

    fun loadString(title : String): String {

   var data= mPref.getString(title,"")

        return data
        }
    fun loadInt(title: String) : Int{
        var data= mPref.getInt(title,0)
        return data
    }  fun loadBoolean(title: String) : Boolean{
        var data= mPref.getBoolean(title,false)
        return data
    }
}