package com.example.shin.mynews.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shin.mynews.controller.fragment.PageFragment


 class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {



    override fun getItem(position: Int): Fragment? {
        when(position)
        {
            0 -> return PageFragment.newInctance(position)
            1 -> return PageFragment.newInctance(position)
            2 -> return PageFragment.newInctance(position)

        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }
}
