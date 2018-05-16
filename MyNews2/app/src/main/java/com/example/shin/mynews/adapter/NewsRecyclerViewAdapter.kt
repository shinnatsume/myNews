package com.example.shin.mynews.adapter


import android.support.v7.widget.CardView
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater

import android.widget.TextView
import com.example.shin.mynews.model.News
import com.example.shin.mynews.R
import com.example.shin.mynews.fragment.PageFragment


class NewsRecyclerViewAdapter(private val news: List<News>, private val newsListener: PageFragment) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>(), View.OnClickListener {

    interface NewsItemListener{
        fun onNewsSelected(news: News)
    }

    override fun onClick(view: View) {
       when (view.id){
           R.id.card_view -> newsListener.onNewsSelected(view.tag as News)
       }
    }

    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val cardView = itemView.findViewById<CardView>(R.id.card_view) !!
//        val imageNews = cardView.findViewById(R.id.image_news) as ImageView
        val titleView = itemView.findViewById<TextView>(R.id.title_news) !!
        val dateNews = itemView.findViewById<TextView>(R.id.date_news) !!
        val textNews = itemView.findViewById<TextView>(R.id.resume_text_news) !!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val viewItem = LayoutInflater.from(parent.context)
               .inflate(R.layout.fragment_page, parent,false)
        return ViewHolder(viewItem)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val newsList = news[position]
        with(holder){
            cardView.tag = newsList
            cardView.setOnClickListener(this@NewsRecyclerViewAdapter)
            titleView.text = newsList.results[position].title
            dateNews.text = newsList.results[position].updateDate
            textNews.text = newsList.results[position].urlArticle
        }
        print(newsList.results[position].title)


    }

    override fun getItemCount(): Int {
        Log.i("onBindViewHolder","onBindViewHolder ${news.size}")
        return news.size
    }
}