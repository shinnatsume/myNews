package com.example.shin.mynews.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shin.mynews.fragment.PageFragment


open class PageAdapter
//Default Constructor
(mgr: FragmentManager,

 private val title: Array<Int>) : FragmentPagerAdapter(mgr) {
    override fun getCount(): Int {
        return 3 //Number of page to show
    }

    override fun getItem(position: Int): Fragment {
        //Item to return
        return PageFragment.newInstance(position, this.title[position].toString())
    }
}