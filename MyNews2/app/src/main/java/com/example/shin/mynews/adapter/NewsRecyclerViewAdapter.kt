package com.example.shin.mynews.adapter


import android.support.v7.widget.CardView
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.widget.ImageView
import android.widget.TextView
import com.example.shin.mynews.model.News
import com.example.shin.mynews.R


class NewsRecyclerViewAdapter(val news: List<News>, val newsListener: NewsRecyclerViewAdapter.NewsItemListener) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>(), View.OnClickListener {

    interface NewsItemListener{
        fun onNewsSelected(news: News)
    }

    override fun onClick(view: View) {
       when (view.id){
           R.id.card_view -> newsListener.onNewsSelected(view.tag as News)
       }
    }

    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val cardView = itemView.findViewById(R.id.card_view)  as CardView
        val imageNews = cardView.findViewById(R.id.image_news) as ImageView
        val titleView = cardView.findViewById(R.id.title) as TextView
        val dateNews = cardView.findViewById(R.id.date_news) as TextView
        val textNews = cardView.findViewById(R.id.resume_text_news) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val viewItem = LayoutInflater.from(parent.context)
               .inflate(R.layout.fragment_page, parent,false)
        return ViewHolder(viewItem)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = news[position]
//        holder.cardView.setOnClickListener(itemClicListener)
        holder.cardView.tag = news
        holder.cardView.setOnClickListener(this@NewsRecyclerViewAdapter)
        holder.titleView.text =news.title
        holder.dateNews.text = news.updateDate
        holder.textNews.text = news.urlArticle.toString()
//        holder.imageNews.setImage(news.image)
    }

    override fun getItemCount(): Int {
        return news.size
    }
}