package com.example.shin.mynews.controller.activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout

import com.example.shin.mynews.R
import com.example.shin.mynews.controller.fragment.PageFragment
import android.support.v4.view.ViewPager
import com.example.shin.mynews.adapter.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.NavigationView

import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.example.shin.mynews.controller.fragment.NewsFragment
import com.example.shin.mynews.controller.fragment.ParamsFragment
import com.example.shin.mynews.controller.fragment.ProfileFragment


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var pageFragment: PageFragment
    //FOR DESIGN
    private var toolbar: android.support.v7.widget.Toolbar? = null
    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null
    //FOR FRAGMENTS
    // 1 - Declare fragment handled by Navigation Drawer
    private var fragmentNews: NewsFragment? = null
    private var fragmentProfile: ProfileFragment? = null
    private var fragmentParams: ParamsFragment? = null

    //FOR DATAS
    // 2 - Identify each fragment with a number
    private val FRAGMENT_NEWS = 0
    private val FRAGMENT_PROFILE = 1
    private val FRAGMENT_PARAMS = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 6 - Configure all views

        this.configureToolBar()

        this.configureDrawerLayout()

        this.configureNavigationView()


        val tabLayout= findViewById<TabLayout>(R.id.tab_layout_main)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val pageAdapter =  PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount())
        viewPager.adapter = pageAdapter


        tabLayout.setupWithViewPager(viewPager)

        /**
         * set title to tabitem
         * */

        tab_layout_main.getTabAt(0)!!.setText("top stories")
        tab_layout_main.getTabAt(1)!!.setText("most popular")
        tab_layout_main.getTabAt(2)!!.setText("search")

        pageFragment = PageFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.activity_main_frame_layout,pageFragment)
                .commit()
    }

    override fun onBackPressed() {
        // 5 - Handle back click to close menu
        if (this.drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override  fun onNavigationItemSelected(item: MenuItem): Boolean {

        // 4 - Handle Navigation Item Click
        val id = item.getItemId()

        when (id) {
            R.id.activity_main_drawer_news -> {
                this.showFragment(FRAGMENT_NEWS)

            }
            R.id.activity_main_drawer_profile -> {
                this.showFragment(FRAGMENT_PROFILE)

            }
            R.id.activity_main_drawer_settings -> {
                this.showFragment(FRAGMENT_PARAMS)

            }
            else -> {
            }
        }

        this.drawerLayout!!.closeDrawer(GravityCompat.START)

        return true
    }

    // ---------------------
    // CONFIGURATION
    // ---------------------

    // 1 - Configure Toolbar
    private fun configureToolBar() {
        this.toolbar = findViewById<View>(R.id.activity_main_toolbar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setHomeButtonEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }

    // 2 - Configure Drawer Layout
    private fun configureDrawerLayout() {
        this.drawerLayout = findViewById<View>(R.id.activity_main_drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout!!.addDrawerListener(toggle)
        toggle.syncState()
    }

    // 3 - Configure NavigationView
    private fun configureNavigationView() {
        this.navigationView = findViewById<View>(R.id.activity_main_nav_view) as NavigationView
        navigationView!!.setNavigationItemSelectedListener(this)
    }

    // ---------------------
    // FRAGMENTS
    // ---------------------

    // 5 - Show fragment according an Identifier

    private fun showFragment(fragmentIdentifier: Int) {
        when (fragmentIdentifier) {
            FRAGMENT_NEWS -> this.showNewsFragment()
            FRAGMENT_PROFILE -> this.showProfileFragment()
            FRAGMENT_PARAMS -> this.showParamsFragment()
            else -> {
            }
        }
    }

    // ---

    // 4 - Create each fragment page and show it

    private fun showNewsFragment() {
        if (this.fragmentNews == null) this.fragmentNews = NewsFragment().newInstance()
        supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main_frame_layout, this.fragmentNews)
                .commit()
    }

    private fun showParamsFragment() {
        if (this.fragmentParams == null) this.fragmentParams = ParamsFragment().newInstance()
//        supportFragmentManager.beginTransaction()
//                .add(R.id.activity_main_frame_layout,fragmentParams)
//                .commit()
    }

    private fun showProfileFragment() {
        if (this.fragmentProfile == null) this.fragmentProfile = ProfileFragment().newInstance()
//        supportFragmentManager.beginTransaction()
//                .add(R.id.activity_main_frame_layout,fragmentProfile)
//                .commit()
    }

}
