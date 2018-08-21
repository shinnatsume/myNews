package com.example.shin.mynews.controller.activity


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import com.example.shin.mynews.R
import android.support.v4.view.ViewPager
import com.example.shin.mynews.adapter.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.View
import com.example.shin.mynews.controller.fragment.*



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var pageFragment: PageFragment
    //FOR DESIGN
    private lateinit var toolbar: android.support.v7.widget.Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView



    //FOR DATAS
    // 1 - Identify each fragment menu DRAWER with a number

    private val FRAGMENT_PROFILE = 2

    // 2 - Identify each fragment menu TOOLBAR with a number
    private val FRAGMENT_SEARCH = 4
    private val FRAGMENT_NOTIFICATION = 5
    private val FRAGMENT_HELP = 6
    private val FRAGMENT_ABOUT = 7


    lateinit var checkboxData :String
    lateinit var beguinDate : String
    lateinit var endDate :String
    lateinit  var textSearch :String

    //FOR TABLAYOUT
    lateinit var tabLayout :TabLayout
    lateinit var viewPager :ViewPager
    lateinit var pageAdapter :PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        tabLayout= findViewById(R.id.tab_layout_main)
        viewPager = findViewById(R.id.viewPager)
        pageAdapter =  PageAdapter(supportFragmentManager)
        viewPager.adapter = pageAdapter
        tabLayout.setupWithViewPager(viewPager)



        // 6 - Configure all views

        this.configureToolBar()



        this.configureDrawerLayout()

        this.configureNavigationView()

        /**
         * set title to tabitem
         * */

        tab_layout_main.getTabAt(0)!!.setText("top stories")
        tab_layout_main.getTabAt(1)!!.setText("most popular")
        tab_layout_main.getTabAt(2)!!.setText("result of search")

        /**
         * when come back from search fragment need to see the result of search in the tab result of search
         * */
        if (intent.getIntExtra("id_tab",0) ==2 && intent.getStringExtra("checkbox data")!= null&& intent.getStringExtra("begin date")!= null
                && intent.getStringExtra("end date")!= null&& intent.getStringExtra("search")!= null){
            tabLayout.getTabAt(2)!!.select()
            checkboxData = intent.getStringExtra("checkbox data").toString()
            beguinDate = intent.getStringExtra("begin date").toString()
            endDate = intent.getStringExtra("end date").toString()
            textSearch = intent.getStringExtra("search").toString()
            pageAdapter.getSearchFragment(2,checkboxData,beguinDate,endDate,textSearch)
        }

    }

    override fun onBackPressed() {
        // 5 - Handle back click to close menu
        if (this.drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    // ---------------------
    // CONFIGURATION
    // ---------------------

    // 1 - Configure Toolbar
    private fun configureToolBar() {
        this.toolbar = findViewById<View>(R.id.toolbar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.title))
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu_toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_activity_main_search -> this.addIdForIntent(FRAGMENT_SEARCH)
            R.id.menu_activity_main_notification -> this.addIdForIntent(FRAGMENT_NOTIFICATION)
            R.id.menu_activity_main_help -> this.addIdForIntent(FRAGMENT_HELP)
            R.id.menu_activity_main_about -> this.addIdForIntent(FRAGMENT_ABOUT)
        }
        return super.onOptionsItemSelected(item)
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

    //put id in intent Extra and go tu detail activity

    private  fun addIdForIntent(idFragmentForIntent: Int){
        val  intent = Intent(this,DetailActivity::class.java)
        when(idFragmentForIntent){
            1->intent.putExtra("id_fragment",1)
            2->intent.putExtra("id_fragment",2)
            3->intent.putExtra("id_fragment",3)
            4->intent.putExtra("id_fragment",4)
            5->intent.putExtra("id_fragment",5)
            6->intent.putExtra("id_fragment",6)
            7->intent.putExtra("id_fragment",7)
        }
        startActivity(intent)
    }

    // 4 - Create each fragment page and show it

    override  fun onNavigationItemSelected(item: MenuItem): Boolean {

        // 4 - Handle Navigation Item Click
        val id = item.getItemId()

        when (id) {
            R.id.activity_main_drawer_top_stories -> {
                tabLayout.getTabAt(0)!!.select()

            }
            R.id.activity_main_drawer_profile -> {
                this.addIdForIntent(FRAGMENT_PROFILE)

            }
            R.id.activity_main_drawer_most_popular -> {
                tabLayout.getTabAt(1)!!.select()
            }
            else -> {

                this.pageFragment = PageFragment()
                supportFragmentManager.beginTransaction()
                        .add(R.id.activity_main_frame_layout,pageFragment)
                        .commit()
            }
        }
        this.drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }

}
