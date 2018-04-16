package com.example.shin.mynews.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shin.mynews.R
import com.example.shin.mynews.adapter.NewsRecyclerViewAdapter
import com.example.shin.mynews.model.Connection
import com.example.shin.mynews.model.News
import com.example.shin.mynews.model.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PageFragment : Fragment() , NewsRecyclerViewAdapter.NewsItemListener{


    private val API_KEY = "7c6d8c349be64838b6b23fc10989e992"


    override fun onNewsSelected(news: News) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    lateinit  var newsList : MutableList<News>



    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRecyclerViewAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Get layout of PageFragment
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val call = Connection.newsService.getTopStories(API_KEY)
        call.enqueue(object :Callback<News>{
            override fun onFailure(call: Call<News>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<News>, response: Response<News>?) {
                for (i in 1..50){
                    response!!.body()?.let { newsList .add(it) }
                }        }

        })
        adapter = NewsRecyclerViewAdapter(newsList,this)
        recyclerView.adapter = adapter
    }
    companion object {

        //Create keys for our Bundle
        private val KEY_POSITION = "position"
        private val KEY_COLOR = "color"


        //Method that will create a new instance of PageFragment, and add data to its bundle.
        fun newInstance(position: Int, color: Int): PageFragment {

            //Create new fragment
            val frag = PageFragment()

            //Create bundle and add it some data
            val args = Bundle()
            args.putInt(KEY_POSITION, position)
            args.putInt(KEY_COLOR, color)
            frag.arguments = args

            return frag
        }
    }

}