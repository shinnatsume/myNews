package com.example.shin.mynews.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shin.mynews.fragment.PageFragment


open class PageAdapter//Default Constructor
(mgr: FragmentManager, //Array of colors that will be passed to PageFragment
 private val colors: IntArray) : FragmentPagerAdapter(mgr) {

    override fun getCount(): Int {
        return 5 //Number of page to show
    }

    override fun getItem(position: Int): Fragment {
        //Item to return
        return PageFragment.newInstance(position, this.colors[position])
    }
}