package com.example.shin.mynews.model.Utils

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import com.example.shin.mynews.R
import com.example.shin.mynews.controller.activity.NotificationActivity

class MyNotification (context: Context){



        val notificationManager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager





        @SuppressLint("NewApi")
        fun notify(context: Context){
            @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
            @SuppressLint("NewApi")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel =  NotificationChannel("channelID","channelName",NotificationManager.IMPORTANCE_DEFAULT)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.setShowBadge(false)
                channel.importance = NotificationManager.IMPORTANCE_DEFAULT
                notificationManager.createNotificationChannel(channel)
            }

            val context = context

            val intent = Intent(context, NotificationActivity::class.java)


            val taskBuilder = TaskStackBuilder.create(context)
            taskBuilder.addParentStack(NotificationActivity::class.java)
            taskBuilder.addNextIntent(intent)

            val pendingIntent = taskBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)




            val builder= NotificationCompat.Builder(context!!,"channelId")

            builder.setAutoCancel(true)

                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("New NEWS in NYT")
                    .setContentText("today you can read new news who interest you")
                    .setContentIntent(pendingIntent)

            notificationManager.notify(1,builder.build())
        }






}