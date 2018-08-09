package com.example.shin.mynews.controller.fragment

import android.content.BroadcastReceiver
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shin.mynews.R
import com.example.shin.mynews.adapter.DocsRecyclerviewAdapter
import com.example.shin.mynews.adapter.NewsRecyclerViewAdapter
import com.example.shin.mynews.model.connectionAndServices.Connection
import com.example.shin.mynews.model.dataClass.Doc
import com.example.shin.mynews.model.dataClass.ResponceSearch
import com.example.shin.mynews.model.dataClass.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PageFragment: Fragment(){


    val ARG_POSITION = " TAB_POSITION"
    val DATA_CHECKBOX ="DATA"
    val DATA_BEGIN_DATE ="BEGIN_DATE"
    val DATA_END_DATE = "END_DATE"
    val DATA_TEXT_SEARCH ="TEXT_SEARCH"



    var recyclerView: RecyclerView? = null
    lateinit var adapterNews: NewsRecyclerViewAdapter
    lateinit var adapterDocs: DocsRecyclerviewAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Get layout of PageFragment
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        recyclerView = view.findViewById(R.id.page_fragment)
        recyclerView!!.layoutManager = LinearLayoutManager(context)





        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        val position = this.arguments?.getSerializable(ARG_POSITION)

       if (position == 0 ){

           val call = Connection.newsServiceJson.getTopStories()
           responce(call)
       }
       if (position == 1){
          val call = Connection.newsServiceJson.getMostPopular()
           responce(call)
       }
       if (position == 2 ){
           val checkBoxData = arguments?.getSerializable(DATA_CHECKBOX).toString()
           var beginDate: String? = arguments?.getSerializable(DATA_BEGIN_DATE).toString()
           var endDate:String? = arguments?.getSerializable(DATA_END_DATE).toString()
           var termOfSearch:String? =arguments?.getSerializable(DATA_TEXT_SEARCH).toString()
           Log.i("argument","${arguments}")



           if (beginDate == "") beginDate = null
           if (endDate == "") endDate = null
           if (termOfSearch == "") termOfSearch = null
           Log.i("DATA","$beginDate+$endDate+$termOfSearch+${checkBoxData.toString()}+$position")
          val call: Call<ResponceSearch> = Connection.newsServiceJson.getArticleSearch(beginDate,endDate,checkBoxData,termOfSearch)

           call?.enqueue(object : Callback<ResponceSearch> {

               override fun onResponse(call: Call<ResponceSearch>?, response: Response<ResponceSearch>?) {


                   val responceDocs = response?.body()
                   Log.i("responce", "$responceDocs")
                    val docs  = responceDocs?.response!!.docs

                   adapterDocs = DocsRecyclerviewAdapter( docs)
                   recyclerView!!.adapter = adapterDocs

               }

               override fun onFailure(call: Call<ResponceSearch>?, t: Throwable?) {
                   Log.e("t", "not connect$t")
               }

           })

       }



    }
/**
 * create new instance of fragment
 * */
    companion object {

        val ARG_POSITION = " TAB_POSITION"
        val DATA_CHECKBOX ="DATA"
        val DATA_BEGIN_DATE ="BEGIN_DATE"
        val DATA_END_DATE = "END_DATE"
        val DATA_TEXT_SEARCH ="TEXT_SEARCH"
        fun newInctance(position: Int): Fragment {
            val  fragments = PageFragment()
            val args = Bundle()
            args.putSerializable(ARG_POSITION,position)

            fragments.arguments = args

            return fragments
        }

    fun newInctanceSearch(position: Int,checkboxData: String,beginDate: String,endDate: String,textSearch: String): Fragment {
        val  fragment = PageFragment()
        val args = Bundle()

        args.putSerializable(ARG_POSITION,position)
        args.putSerializable(DATA_CHECKBOX,checkboxData)
        args.putSerializable(DATA_BEGIN_DATE,beginDate)
        args.putSerializable(DATA_END_DATE,endDate)
        args.putSerializable(DATA_TEXT_SEARCH,textSearch)
        Log.i("data","${args}")
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

                adapterNews = NewsRecyclerViewAdapter(news?.results!!)
                recyclerView!!.adapter = adapterNews

            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.e("t", "not connect$t")
            }

        })
    }


}

