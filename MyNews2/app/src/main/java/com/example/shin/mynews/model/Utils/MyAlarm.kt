package com.example.shin.mynews.model.Utils
import  android.content.BroadcastReceiver
import android.content.Context

import android.content.Intent



class MyAlarm : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

            val  notification = MyNotification(context!!).notify(context)


    }

}