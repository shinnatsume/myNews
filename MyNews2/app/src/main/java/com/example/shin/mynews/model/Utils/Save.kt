package com.example.shin.mynews.model.Utils

import android.content.Context
import android.content.SharedPreferences

class Save(context: Context) {




    var mPref :SharedPreferences = context.getSharedPreferences("save",0)
    var editor : SharedPreferences.Editor = mPref.edit()




    fun saveString(data: String,title: String) {
        editor.putString(title,data)
        editor.apply()
    }

    fun saveBoolean(data: Boolean,title: String) {
        editor.putBoolean(title,data)
        editor.apply()
    }
    fun saveInt(data: Int,title: String) {
        editor.putInt(title,data)
        editor.apply()
    }
}
