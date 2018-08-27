package com.example.shin.mynews.controler.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shin.mynews.R
import com.example.shin.mynews.adapter.NewsRecyclerViewAdapter
import com.example.shin.mynews.model.dataClass.News
import com.example.shin.mynews.model.connectionAndServices.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PageFragment: Fragment(), NewsRecyclerViewAdapter.NewsItemListener{

    override fun onNewsSelected(news: News) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val ARG_POSITION = " TAB_POSITION"




    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRecyclerViewAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Get layout of PageFragment
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        recyclerView = view.findViewById(R.id.page_fragment_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val position = this.arguments?.getSerializable(ARG_POSITION)
        if (position == 0 ){

            val call = Connection.newsServiceJson.getTopStories()
            responce(call)
        }
        else if (position == 1){
            val call = Connection.newsServiceJson.getMostPopular()
            responce(call)
        }
//       else if (position == 2 ){
//          val call = Connection.newsServiceJson.getArticleSearch()
//             responce(call)
//       }



    }
    /**
     * create new instance of fragment
     * */
    companion object {

        val ARG_POSITION = " TAB_POSITION"

        fun newInctance(position: Int): Fragment {
            val  fragment = PageFragment()
            val args = Bundle()
            args.putSerializable(ARG_POSITION,position)
            fragment.arguments = args
            return fragment
        }


    }


    /**
     * funtion for call retrofit enqueue and display responce on recyclerview
     * */
    fun responce(call: Call<News>?) {
        call?.enqueue(object : Callback<News> {

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
//                Log.i("connect", "connect${response?.body()}")

                val news = response?.body()
//                Log.i("size of", "size of ${news.toString()}")

                adapter = NewsRecyclerViewAdapter(news!!.results, this)
                recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.e("t", "not connect$t")
            }

        })
    }
}

