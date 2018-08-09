package com.example.shin.mynews.model.Utils
import  android.content.BroadcastReceiver
import android.content.Context

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.R.id.action_bar_root
import android.support.design.R.id.container
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.shin.mynews.R
import com.example.shin.mynews.R.id.recyclerViewNotification
import com.example.shin.mynews.adapter.DocsRecyclerviewAdapter
import com.example.shin.mynews.model.connectionAndServices.Connection
import com.example.shin.mynews.model.dataClass.Doc
import com.example.shin.mynews.model.dataClass.ResponceSearch
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyAlarm : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val notificationSwitchBtn = Load(context!!).loadBoolean("notification")

        if (notificationSwitchBtn == true){
            val  notification = MyNotification(context!!).notify(context)
        }
    }
}