package com.example.shin.mynews.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shin.mynews.controller.fragment.PageFragment


// class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
//
//      var numOfTabs: Int? = null
//
//    fun PageAdapter(fm: FragmentManager, numOfTabs: Int) {
//        super.onCreate(fm)
//        this.numOfTabs = numOfTabs
//    }
//
//    override fun getItem(position: Int): Fragment? {
//        when(position)
//        {
//            0 -> return PageFragment.newInctance(position)
//            1 -> return PageFragment.newInctance(position)
//            2 -> return PageFragment.newInctance(position)
//
//        }
//        return null
//    }
//
//    override fun getCount(): Int {
//        return numOfTabs!!
//    }
//}
class PageAdapter internal constructor(fm: FragmentManager, private val numOfTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return PageFragment.newInctance(position)
            1 -> return PageFragment.newInctance(position)
            2 -> return PageFragment.newInctance(position)
            else -> return null
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}