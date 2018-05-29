package com.example.shin.mynews.controller.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.widget.Toolbar
import com.example.shin.mynews.R
import com.example.shin.mynews.controller.fragment.PageFragment
import android.support.v4.view.ViewPager
import android.support.design.widget.TabItem
import com.example.shin.mynews.adapter.PageAdapter
import com.example.shin.mynews.R.id.viewPager








class MainActivity : AppCompatActivity() {

    private lateinit var pageFragment: PageFragment


    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val toolbar =findViewById(R.id.toolbar) as Toolbar
//        toolbar.setTitle(resources.getString(R.string.app_name))
        val  tabLayout= findViewById(R.id.tablayout) as TabLayout
//        val tabTopStories = findViewById(R.id.top_stories_tab) as TabItem
//        val tabMostPopular= findViewById(R.id.most_popular_tab) as TabItem
//        val tabSearch = findViewById(R.id.search_tab) as TabItem
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val pageAdapter = PageAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.setAdapter(pageAdapter)

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))


        pageFragment = PageFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.container,pageFragment)
                .commit()
    }


}
