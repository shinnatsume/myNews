package com.example.shin.mynews.adapter



import android.annotation.SuppressLint
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.shin.mynews.R
import com.example.shin.mynews.model.dataClass.News
import com.example.shin.mynews.model.dataClass.Results

import retrofit2.Callback

import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class NewsRecyclerViewAdapter(private val news: List<Results>, private val newsListener: Callback<News>) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>(), View.OnClickListener {


    interface NewsItemListener{
        fun onNewsSelected(news: News)
    }

    override fun onClick(view: View) {
        when (view.id){
//           R.id.card_view -> newsListener.onNewsSelected(view.tag as News)
        }
    }

    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val context = itemView.context
        val cardView = itemView.findViewById<CardView>(R.id.card_view) !!
        val imageNews = cardView.findViewById(R.id.image_news) as ImageView
        val sectionView = itemView.findViewById<TextView>(R.id.section_news) !!
        val dateNews = itemView.findViewById<TextView>(R.id.date_news) !!
        val titleNews = itemView.findViewById<TextView>(R.id.title_news) !!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_format, parent,false)
        return ViewHolder(viewItem)
    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val newsList = news[position]



        with(holder){
            cardView.tag = newsList
            cardView.setOnClickListener(this@NewsRecyclerViewAdapter)
            /**
             * show image in image view
             * */
            if (newsList.multimedia?.first()?.url != null){
                Picasso.with(context).load(newsList.multimedia?.first()?.url).into(holder.imageNews)
            }
            if (newsList.media?.first()?.mediaImage?.first()?.urlImage != null && newsList.multimedia?.first()?.url == null){
                Picasso.with(context).load(newsList.media?.first()?.mediaImage?.first()?.urlImage).into(holder.imageNews)
            }

            /**
             * verification of the presence of a subtitle and display
             * */

            if (newsList.subsection == null || newsList.subsection.isEmpty()){
                sectionView.text = newsList.section
            }else if(newsList.subsection != null){
                sectionView.text = "${newsList.section} ->  ${newsList.subsection}"
            }


//            val currentDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.FRANCE)
//            val currentDate= currentDateFormat.parse(newsList.publishedDate)
//            dateNews.text = currentDate?.toString()
            dateNews.text = newsList.publishedDate
            titleNews.text = newsList.title

        }



    }

    override fun getItemCount(): Int {
        Log.i("onBindViewHolder","onBindViewHolder ${news.size}")
        return news.size
    }
}

