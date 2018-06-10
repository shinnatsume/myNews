package com.example.shin.mynews.controller.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Switch
import com.example.shin.mynews.R
import kotlinx.android.synthetic.main.fragment_search_and_notification.*


class SearchAndNotificationFragment : Fragment() {
    val ID_FRAGMENT_OPTION = "ID_FRAGMENT_OPTION"
   
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_and_notification, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notificationSwitchBtn =view.findViewById(R.id.notification_switch) as Switch
                val id_Fragment_View = this.arguments?.getSerializable(ID_FRAGMENT_OPTION)

       when (id_Fragment_View ){
           0-> {
               notificationSwitchBtn.visibility = View.GONE

           }
            1->{ Search_btn.visibility =GONE
           begin_date.visibility = GONE
                   begin_date_edit.visibility = GONE
                   end_date.visibility= GONE
                   end_date_edit.visibility = GONE
            }
        }



        }

    }

    fun newInstance(id_Fragment_View :Int): Fragment{
        val ID_FRAGMENT_OPTION = "ID_FRAGMENT_OPTION"
        val fragment = SearchAndNotificationFragment()
        val args = Bundle()
        args.putSerializable(ID_FRAGMENT_OPTION,id_Fragment_View)
        fragment.arguments = args
        Log.i("id fragment", "${id_Fragment_View}")
        return fragment
    }



}
