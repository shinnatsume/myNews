package com.example.shin.mynews.controller.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shin.mynews.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_search_and_notification.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlin.concurrent.fixedRateTimer


class SearchAndNotificationFragment : Fragment() {
    val ID_FRAGMENT_OPTION = "ID_FRAGMENT_OPTION"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_and_notification, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                val id_Fragment_View = this.arguments?.getSerializable(ID_FRAGMENT_OPTION)
       when (id_Fragment_View ){
           0-> {
               notification_switch.visibility = View.INVISIBLE
           }
            1-> Search_btn.visibility = View.INVISIBLE
        }
    }

    fun newInstance(id_Fragment_View :Int): Fragment{
        val ID_FRAGMENT_OPTION = "ID_FRAGMENT_OPTION"
        val fragment = SearchAndNotificationFragment()
        val args = Bundle()
        args.putSerializable(ID_FRAGMENT_OPTION,id_Fragment_View)
        fragment.arguments = args

        return fragment
    }


}
