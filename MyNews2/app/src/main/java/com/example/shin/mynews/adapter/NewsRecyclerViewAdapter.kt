package com.example.shin.mynews.adapter


import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shin.mynews.R
import com.example.shin.mynews.model.News
import com.example.shin.mynews.model.Results
import retrofit2.Callback


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
        val cardView = itemView.findViewById<CardView>(R.id.card_view) !!
//        val imageNews = cardView.findViewById(R.id.image_news) as ImageView
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

//        val format: String = "dd/mm/YYYY"
//       var simpleDateFormat = SimpleDateFormat(format, Locale.FRANCE)
//       var currentDate = simpleDateFormat.format(news[position].updateDate)

        val newsList = news[position]
        with(holder){
            cardView.tag = newsList
            cardView.setOnClickListener(this@NewsRecyclerViewAdapter)
            sectionView.text = "${newsList.section} ->  ${newsList.subsection}"
            dateNews.text = newsList.updateDate
            titleNews.text = newsList.title
        }



    }

    override fun getItemCount(): Int {
        Log.i("onBindViewHolder","onBindViewHolder ${news.size}")
        return news.size
    }
}