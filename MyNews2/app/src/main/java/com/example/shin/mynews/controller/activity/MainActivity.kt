package com.example.shin.mynews.controller.activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout

import com.example.shin.mynews.R
import com.example.shin.mynews.controller.fragment.PageFragment
import android.support.v4.view.ViewPager
import com.example.shin.mynews.adapter.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var pageFragment: PageFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val tabLayout= findViewById<TabLayout>(R.id.tablayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val pageAdapter = PageAdapter(supportFragmentManager)
        viewPager.adapter = pageAdapter


        tabLayout.setupWithViewPager(viewPager)

        /**
         * set title to tabitem
         * */

        tablayout.getTabAt(0)!!.setText("top stories")
        tablayout.getTabAt(1)!!.setText("most popular")
        tablayout.getTabAt(2)!!.setText("search")


        pageFragment = PageFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.container,pageFragment)
                .commit()
    }


}
