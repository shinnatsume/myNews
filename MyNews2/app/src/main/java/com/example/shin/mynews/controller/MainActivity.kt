package com.example.shin.mynews.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.TableLayout
import com.example.shin.mynews.fragment.PageFragment
import com.example.shin.mynews.model.News
import com.example.shin.mynews.R
import com.example.shin.mynews.adapter.PageAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var pageFragment: PageFragment

    lateinit var  news : MutableList<News>
    val tabs = arrayOf(1,2,3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        news= mutableListOf<News>()
//
//        val  tabLayout= findViewById(R.id.activity_main_tabs) as TableLayout
//      this.confugureViewPager()

        pageFragment = PageFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.container,pageFragment)
                .commit()
    }

//    private fun confugureViewPager() {
//        //Get ViewPager from layout
//        val pager = findViewById(R.id.viewPager) as ViewPager
//        //Set Adapter PageAdapter and glue it together
//        pager.adapter = object : PageAdapter(mgr = supportFragmentManager, title = tabs) {


            // 1 - Get TabLayout from layout

//            val  tabLayout= findViewById(R.id.activity_main_tabs) as TableLayout

            // 2 - Glue TabLayout and ViewPager together

//            tabLayout.setupWithViewPager(pager)

            // 3 - Design purpose. Tabs have the same width

          //  tabLayout.setTabMode(TabLayout.MODE_FIXED)
//        }
//    }
}
