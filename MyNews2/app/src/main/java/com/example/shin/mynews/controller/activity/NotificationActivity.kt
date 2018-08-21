package com.example.shin.mynews.controller.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.example.shin.mynews.R
import com.example.shin.mynews.adapter.DocsRecyclerviewAdapter
import com.example.shin.mynews.model.Utils.Load
import com.example.shin.mynews.model.connectionAndServices.Connection
import com.example.shin.mynews.model.dataClass.Doc
import com.example.shin.mynews.model.dataClass.ResponceSearch
import kotlinx.android.synthetic.main.activity_notification.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationActivity : AppCompatActivity() {

    lateinit var docs :List<Doc>
    private lateinit var toolbar: android.support.v7.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("News notification")
        this.configureToolBar()

        val context : Context = this

        val CHECKBOX_DATA = Load(context!!).loadString("chexbox")
        val begin =Load(context!!).loadString("date")
        val EDIT_TEXT_INPUT = Load(context!!).loadString("editText")

        val call: Call<ResponceSearch> = Connection.newsServiceJson.getArticleSearch(begin,null,CHECKBOX_DATA,EDIT_TEXT_INPUT)

        call?.enqueue(object : Callback<ResponceSearch> {

            @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
            override fun onResponse(call: Call<ResponceSearch>?, response: Response<ResponceSearch>?) {
                val responceDocs = response?.body()
                Log.i("responce", "$responceDocs")
                docs  = responceDocs?.response!!.docs
                recyclerViewNotification!!.layoutManager = LinearLayoutManager(context)
                var   adapterDocs = DocsRecyclerviewAdapter( docs)
                recyclerViewNotification!!.adapter = adapterDocs
            }
            override fun onFailure(call: Call<ResponceSearch>?, t: Throwable?) {
                Log.e("t", "not connect$t")
            }
        })
    }

    private fun configureToolBar() {
        this.toolbar = findViewById<View>(R.id.toolbar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        toolbar.setTitleTextColor(resources.getColor(R.color.title))
        actionBar!!.setDisplayShowTitleEnabled(true)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    override fun
            onOptionsItemSelected( item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home->{
                // todo: goto back activity from here
                intent   = Intent(this, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP )
                startActivity(intent)
                return true
            }
        }
        return false
    }

}
