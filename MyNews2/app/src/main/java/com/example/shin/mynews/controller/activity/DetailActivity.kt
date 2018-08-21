package com.example.shin.mynews.controller.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.shin.mynews.R
import com.example.shin.mynews.controller.fragment.*
import com.example.shin.mynews.model.dataClass.News
import com.example.shin.mynews.model.dataClass.Results

class DetailActivity : AppCompatActivity() {


    private lateinit var toolbar: android.support.v7.widget.Toolbar
    //FOR FRAGMENTS


    private lateinit var fragmentProfile: ProfileFragment
    private lateinit var fragmentSearch: SearchAndNotificationFragment
    private lateinit var fragmentHelp: HelpFragment
    private lateinit var fragmentAbout: AboutFragment
    private lateinit var fragmentDetailNews: DetailNewsFragment
    private  lateinit var news: Results
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar = findViewById(R.id.toolbar)
        this.configureToolBar()

        //1 init fragment

        fragmentProfile = ProfileFragment()
        fragmentSearch = SearchAndNotificationFragment()
        fragmentAbout = AboutFragment()
        fragmentHelp = HelpFragment()
        fragmentDetailNews = DetailNewsFragment()

        val   ARGS_ID_FRAGMENT = intent.getIntExtra("id_fragment",0)

        when(ARGS_ID_FRAGMENT){
            2->{
                this.showProfileFragment()
                toolbar.setTitle("profile")
            }
            4->{
                this.showSearchFragment()
                toolbar.setTitle("search")
            }
            5->{
                this.showNotificationFragment()
                toolbar.setTitle("notification")
            }
            6->{
                this.showHelpFragment()
                toolbar.setTitle("help")
            }
            7->{
                this.showAboutFragment()
                toolbar.setTitle("about")
            }8->{
            this.showDetailNewsFragment()
            toolbar.setTitle("detail news")
        }
        }
    }

    /**
     * configure toolbar and back press
     * */
    private fun configureToolBar() {
        this.toolbar = findViewById<View>(R.id.toolbar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        toolbar.setTitleTextColor(resources.getColor(R.color.title))
        actionBar!!.setDisplayShowTitleEnabled(false)
        actionBar!!.setDisplayHomeAsUpEnabled(true)

    }


    /**
     * show fragment
     * */
    private fun showSearchFragment(){

        val ID_SEARCH_FRAGMENT = 0
        this.fragmentSearch = SearchAndNotificationFragment().newInstance(ID_SEARCH_FRAGMENT) as SearchAndNotificationFragment
        this.startTransactionFragment(fragmentSearch)
    }
    private fun showNotificationFragment(){
        val ID_SEARCH_FRAGMENT = 1
        this.fragmentSearch = SearchAndNotificationFragment().newInstance(ID_SEARCH_FRAGMENT) as SearchAndNotificationFragment
        this.startTransactionFragment(fragmentSearch)
    }



    private fun showProfileFragment() {
        this.fragmentProfile = ProfileFragment().newInstance()
        this.startTransactionFragment(fragmentProfile)
    }

    private fun showAboutFragment() {
        this.fragmentAbout = AboutFragment().newInstance()
        this.startTransactionFragment(fragmentAbout)
    }

    private fun showHelpFragment() {
        this.fragmentHelp = HelpFragment().newInstance()
        this.startTransactionFragment(fragmentHelp)
    }

    private fun showDetailNewsFragment() {
        news = intent.getSerializableExtra("news") as Results
        this.fragmentDetailNews = DetailNewsFragment().newInstance(news)
        this.startTransactionFragment(fragmentDetailNews)
    }


    // 3 - Generic method that will replace and show a fragment inside the detailActivity Frame Layout
    fun startTransactionFragment(fragment: Fragment?){


        if (fragment?.isVisible != true){
            val fm = supportFragmentManager.beginTransaction()
            fm.replace(R.id.activity_detail_frame_layout, fragment)
            fm.isAddToBackStackAllowed
            fm.commit()
        }
    }
}
