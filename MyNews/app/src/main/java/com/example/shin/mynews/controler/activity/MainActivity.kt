package com.example.shin.mynews.controler.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import com.example.shin.mynews.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.widget.DrawerLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.example.shin.mynews.adapter.PageAdapter
import com.example.shin.mynews.controler.fragment.PageFragment


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var pageFragment: PageFragment
    //FOR DESIGN
    private var toolbar: Toolbar? = null
    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 6 - Configure all views

        this.configureToolBar()

        this.configureDrawerLayout()

        this.configureNavigationView()


        val tabLayout= findViewById<TabLayout>(R.id.tab_layout_main)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val pageAdapter = PageAdapter(supportFragmentManager)
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
            }
            R.id.activity_main_drawer_profile -> {
            }
            R.id.activity_main_drawer_settings -> {
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
        this.toolbar = findViewById<View>(R.id.activity_main_toolbar) as Toolbar
        setSupportActionBar(toolbar)
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
}