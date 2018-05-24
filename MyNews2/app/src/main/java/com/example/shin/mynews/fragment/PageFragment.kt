package com.example.shin.mynews.fragment

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
import com.example.shin.mynews.model.Connection
import com.example.shin.mynews.model.News

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PageFragment : Fragment() , NewsRecyclerViewAdapter.NewsItemListener{

//    override fun onResponse(response: News) {
//        this.updateList(response)
//        Log.e("responce","$response")
//    }
//
//    private fun updateList(response: News): MutableList<News> {
//        newsList = mutableListOf<News>()
//        newsList.add(response)
//        return newsList
//    }

//    override fun onFailure() {
//        Log.e("t","not connect")
//    }


    override fun onNewsSelected(news: News) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var newsList : MutableList<News>
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

        newsList = mutableListOf<News>()


        val call = Connection.newsServiceJson.getTopStories()

        call.enqueue(object : Callback<News>{

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                Log.i("connect","connect${response?.body()}")

                val news = response?.body()

                adapter = NewsRecyclerViewAdapter(news!!.results,this)
                recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.e("t","not connect$t")
            }


        })




    }







    companion object {

        //Create keys for our Bundle
        private val KEY_POSITION = "position"
        private val KEY_COLOR = "color"
        private  val KEY_TiTLE ="title"


        //Method that will create a new instance of PageFragment, and add data to its bundle.
        fun newInstance(position: Int, title : String): PageFragment {

            //Create new fragment
            val frag = PageFragment()

            //Create bundle and add it some data
            val args = Bundle()
            args.putInt(KEY_POSITION, position)
            args.putString(KEY_TiTLE,title)
//            args.putInt(KEY_COLOR, color)
            frag.arguments = args

            return frag
        }
    }

}

//private fun <News> Callback<News>.updateNews(response: Response<News>) {
//    var list = mutableListOf<News>(response.body()!!)
//}
