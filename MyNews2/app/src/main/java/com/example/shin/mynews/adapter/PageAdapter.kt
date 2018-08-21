package com.example.shin.mynews.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shin.mynews.controller.fragment.PageFragment


class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var checkboxData : String = ""
    var beguinDate : String = ""
    var endDate : String = ""
    var textSearch : String = ""

    fun getSearchFragment(position: Int, checkboxData: String, beguinDate: String, endDate: String, textSearch: String) {
        this.checkboxData = checkboxData
        this.beguinDate = beguinDate
        this.endDate = endDate
        this.textSearch = textSearch
        PageFragment.newInctanceSearch(position, checkboxData, beguinDate, endDate, textSearch)
    }



    override fun getItem(position: Int): Fragment? {

        when(position)
        {
            0 -> return PageFragment.newInctance(position)
            1 -> return PageFragment.newInctance(position)
            2 -> return PageFragment.newInctanceSearch(position, checkboxData, beguinDate, endDate, textSearch)
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }
}
