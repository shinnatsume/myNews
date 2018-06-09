package com.example.shin.mynews.controller.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.shin.mynews.R
import com.example.shin.mynews.controller.fragment.*

class DetailActivity : AppCompatActivity() {


    private lateinit var toolbar: android.support.v7.widget.Toolbar
    //FOR FRAGMENTS

    private lateinit var fragmentNews: NewsFragment
    private lateinit var fragmentProfile: ProfileFragment
    private lateinit var fragmentParams: ParamsFragment
    private lateinit var fragmentSearch: SearchAndNotificationFragment
    private lateinit var fragmentHelp: HelpFragment
    private lateinit var fragmentAbout: AboutFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar = findViewById(R.id.toolbar)

        this.configureToolBar()

        //1 init fragment
        fragmentNews = NewsFragment()
        fragmentParams = ParamsFragment()
        fragmentProfile = ProfileFragment()
        fragmentSearch = SearchAndNotificationFragment()
        fragmentAbout = AboutFragment()
        fragmentHelp = HelpFragment()

        val   ARGS_ID_FRAGMENT = intent.getIntExtra("id_fragment",0)

        when(ARGS_ID_FRAGMENT){
            1->{
                this.showNewsFragment()
                toolbar.setTitle("news")
            }

            2->{
                this.showProfileFragment()
                toolbar.setTitle("profile")
            }
            3->{
                this.showParamsFragment()
                toolbar.setTitle("parametre")
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
        if (this.fragmentSearch == null) this.fragmentSearch = SearchAndNotificationFragment().newInstance(ID_SEARCH_FRAGMENT) as SearchAndNotificationFragment
        this.startTransactionFragment(fragmentSearch)
    }
    private fun showNotificationFragment(){
        val ID_SEARCH_FRAGMENT = 1
        if (this.fragmentSearch == null) this.fragmentSearch = SearchAndNotificationFragment().newInstance(ID_SEARCH_FRAGMENT) as SearchAndNotificationFragment
        this.startTransactionFragment(fragmentSearch)
    }

    private fun showNewsFragment() {
        if (this.fragmentNews == null) this.fragmentNews = NewsFragment().newInstance()
        this.startTransactionFragment(fragmentNews)
    }



    private fun showParamsFragment() {
        if (fragmentParams == null) this.fragmentParams = ParamsFragment().newInstance()
        startTransactionFragment(fragmentParams)

    }

    private fun showProfileFragment() {
        if (this.fragmentProfile == null) this.fragmentProfile = ProfileFragment().newInstance()
        this.startTransactionFragment(fragmentProfile)
    }

    private fun showAboutFragment() {
        if (this.fragmentProfile == null) this.fragmentProfile = ProfileFragment().newInstance()
        this.startTransactionFragment(fragmentProfile)
    }

    private fun showHelpFragment() {
        if (this.fragmentProfile == null) this.fragmentProfile = ProfileFragment().newInstance()
        this.startTransactionFragment(fragmentProfile)
    }


    // 3 - Generic method that will replace and show a fragment inside the MainActivity Frame Layout
    fun startTransactionFragment(fragment: Fragment?){


        if (fragment?.isVisible != true){

            val fm = supportFragmentManager.beginTransaction()
            fm.replace(R.id.activity_detail_frame_layout, fragment)
            fm.isAddToBackStackAllowed
            fm.commit()



        }
    }

}
