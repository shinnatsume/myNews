package com.example.shin.mynews.controller.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.shin.mynews.R
import android.util.Log

/**
 * A simple [Fragment] subclass.
 *
 */
class NewsFragment : Fragment() {

    fun newInstance(): NewsFragment {

        return NewsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


}