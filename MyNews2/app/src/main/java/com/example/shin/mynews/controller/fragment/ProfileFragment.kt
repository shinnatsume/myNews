package com.example.shin.mynews.controller.fragment


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker

import com.example.shin.mynews.R
import com.example.shin.mynews.controller.activity.MainActivity
import com.example.shin.mynews.model.Utils.MyAlarm
import kotlinx.android.synthetic.main.activity_main_nav_header.*
import java.security.spec.PKCS8EncodedKeySpec
import java.sql.Time
import java.util.*


@Suppress("DEPRECATION")
/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {
    var ProfileName :String =""

    fun newInstance(): ProfileFragment {
        return ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameText = view.findViewById<EditText>(R.id.name_profile_edit)
        val validateNameBtn = view.findViewById<Button>(R.id.validate_name_btn)
        val validateHoursBtn = view.findViewById<Button>(R.id.validate_hours_btn)
        val hours = view.findViewById<TimePicker>(R.id.hours_notification)
        val intent = Intent(context,MainActivity::class.java)
        if (nameText.text != null ){
            validateNameBtn.setOnClickListener {

                 ProfileName =  nameText.text.toString()
//                name_profile.text = ProfileName
//                intent.putExtra("nameProfile",ProfileName)
//                startActivity(intent)
            }
        }
        validateHoursBtn.setOnClickListener {

          var  hoursToGetNotification  = hours.currentHour
          var  minToGetNotification = hours.currentMinute
            val calendar = Calendar.getInstance()
            if (android.os.Build.VERSION.SDK_INT >= 23){
                calendar.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,hoursToGetNotification,minToGetNotification,0)
            }
                setAlarm(calendar.timeInMillis)

            intent.putExtra("hours", hoursToGetNotification)
            intent.putExtra("min",minToGetNotification)
            startActivity(intent)

        }



    }


    fun setAlarm(long: Long){
     val   alarmManager :AlarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
      val  intent = Intent(context,MyAlarm::class.java)
       val pendingIntent =  PendingIntent.getBroadcast(context,0, intent, 0)
        alarmManager.setRepeating(AlarmManager.RTC, long,AlarmManager.INTERVAL_DAY,pendingIntent)
    }

}

