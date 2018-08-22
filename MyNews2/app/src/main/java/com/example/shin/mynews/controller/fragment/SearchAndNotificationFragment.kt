package com.example.shin.mynews.controller.fragment


import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Switch
import android.widget.Toast
import com.example.shin.mynews.R
import com.example.shin.mynews.controller.activity.MainActivity
import com.example.shin.mynews.model.Utils.Load
import com.example.shin.mynews.model.Utils.Save
import kotlinx.android.synthetic.main.fragment_search_and_notification.*
import java.text.SimpleDateFormat
import java.util.*


class SearchAndNotificationFragment : Fragment() {
    var DATA_CHAR =""
    var ART =""
    var TRAVEL =""
    var POLITICS =""
    var BUSINESS =""
    var ENTREPRENEUR =""
    var SPORT =""
    var BEGIN_DATE =""
    var END_DATE =""
    var EDIT_TEXT_INPUT =""
    var CHECKBOX_DATA = ""
    val ID_FRAGMENT_OPTION = "ID_FRAGMENT_OPTION"
    var itemSelected = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_and_notification, container, false)

    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notificationSwitchBtn = view.findViewById(R.id.notification_switch) as Switch

        val id_Fragment_View = this.arguments?.getSerializable(ID_FRAGMENT_OPTION)

        val notificationBtn = Load(context!!).loadBoolean("notification")
        val CHECKBOX_DATA = Load(context!!).loadString("chexbox")
        val EDIT_TEXT_INPUT = Load(context!!).loadString("editText")

        if ( notificationBtn == true) notificationSwitchBtn.isChecked= true

        setSelectedCheckBox(art)
        setSelectedCheckBox(sport)
        setSelectedCheckBox(business)
        setSelectedCheckBox(entrepreneurs)
        setSelectedCheckBox(politics)
        setSelectedCheckBox(travel)

        when (id_Fragment_View) {
            0 -> {
                notificationSwitchBtn.visibility = View.GONE
            }
            1 -> {
                Search_btn.visibility = GONE
                begin_date.visibility = GONE
                begin_date_edit.visibility = GONE
                end_date.visibility = GONE
                end_date_edit.visibility = GONE
            }
        }




        val format = "yyyyMMdd"
        val currentDateFormat = SimpleDateFormat(format)
        val inputFormat = SimpleDateFormat("dd/MM/yyyy")

        notificationSwitchBtn.setOnCheckedChangeListener { buttonView, isChecked ->

            if( notificationSwitchBtn.isChecked == true ){
                val date = Date()
                val begin = currentDateFormat.format(date)

                Save(context!!).saveString(begin,"date")
                Save(context!!).saveString(EDIT_TEXT_INPUT,"editText")
                Save(context!!).saveString(CHECKBOX_DATA,"chexbox")
                Save(context!!).saveBoolean(true,"notification")

            }else {

                Save(context!!).saveBoolean(false,"notification")

            }
        }


        Search_btn.setOnClickListener {
            if (itemSelected >=1 && search_edit_text.length()>0){


                if (begin_date_edit.length() == 10) {
                    val date = inputFormat.parse(begin_date_edit.text.toString())
                    BEGIN_DATE = currentDateFormat.format(date)
                    Log.i("date", "$BEGIN_DATE")
                }

                if (end_date_edit.length() == 10){
                    val date = inputFormat.parse(end_date_edit.text.toString())
                    END_DATE = currentDateFormat.format(date)
                    Log.i("date", "$END_DATE")
                }

                if (search_edit_text.length() > 0) this.EDIT_TEXT_INPUT = search_edit_text.text.toString()

                val mPreferences = context!!.getSharedPreferences("id total search",0)
                val editor :SharedPreferences.Editor = mPreferences.edit()

                editor.apply()

                val intent = Intent(context,MainActivity::class.java)

                intent.putExtra("checkbox data", CHECKBOX_DATA.toString())
                intent.putExtra("begin date", BEGIN_DATE.toString())
                intent.putExtra("end date", END_DATE.toString())
                intent.putExtra("search", EDIT_TEXT_INPUT.toString())
                intent.putExtra("id_tab", 2)
                startActivity(intent)

            }else{
                Toast.makeText(context,"please check at least one of the checkboxes if above ",Toast.LENGTH_LONG).show()
            }

        }
    }


    fun newInstance(id_Fragment_View: Int): Fragment {
        val ID_FRAGMENT_OPTION = "ID_FRAGMENT_OPTION"
        val fragment = SearchAndNotificationFragment()
        val args = Bundle()
        args.putSerializable(ID_FRAGMENT_OPTION, id_Fragment_View)
        fragment.arguments = args
        Log.i("id fragment", "${id_Fragment_View}")
        return fragment
    }

    fun setSelectedCheckBox(checkBox: CheckBox){
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (checkBox.isChecked){
                DATA_CHAR = "%26${checkBox.text}"
                itemSelected +=1
            }else{
                itemSelected -=1
                DATA_CHAR = ""
            }


            if (DATA_CHAR == "%26art") {
                ART = DATA_CHAR

            } else if (DATA_CHAR == ""){
                ART= ""

            }
            if (DATA_CHAR == "%26business"){
                BUSINESS = DATA_CHAR

            } else if (DATA_CHAR == ""){
                BUSINESS= ""

            }
            if (DATA_CHAR == "%26sport"){
                SPORT = DATA_CHAR

            } else if (DATA_CHAR == "") {
                SPORT= ""

            }
            if (DATA_CHAR == "%26entrepreneurs"){
                ENTREPRENEUR = DATA_CHAR

            } else if (DATA_CHAR == "") {
                ENTREPRENEUR= ""

            }
            if (DATA_CHAR == "%26politics") {
                POLITICS = DATA_CHAR

            } else if (DATA_CHAR == ""){
                POLITICS= ""

            }
            if (DATA_CHAR == "%26travel"){
                TRAVEL = DATA_CHAR
            } else if (DATA_CHAR == ""){
                TRAVEL= ""

            }
            CHECKBOX_DATA = ART + BUSINESS + POLITICS+ SPORT + ENTREPRENEUR + TRAVEL

        }


    }

}




