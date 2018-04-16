package com.example.shin.mynews.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shin.mynews.fragment.PageFragment
import com.example.shin.mynews.model.News
import com.example.shin.mynews.R


class MainActivity : AppCompatActivity() {

    private lateinit var pageFragment: PageFragment

    lateinit var  news : MutableList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        news= mutableListOf<News>()


//      this.confugureViewPager()
//
        pageFragment = PageFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.container,pageFragment)
                .commit()
    }

//    private fun confugureViewPager() {
//        //Get ViewPager from layout
//        val pager = findViewById(R.id.container) as ViewPager
//        //Set Adapter PageAdapter and glue it together
//        pager.adapter = object : PageAdapter(mgr = supportFragmentManager, colors = resources.getIntArray(R.array.colorPagesViewPager)) {
//
//        }
//    }
}
