package com.example.shin.mynews.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shin.mynews.R
import com.example.shin.mynews.model.dataClass.Doc
import com.google.gson.Gson

class NotificationRecyclerViewAdapter(private val docs :List<Doc>) : RecyclerView.Adapter<NotificationRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val context = itemView.context
        val titleDocs = itemView.findViewById<TextView>(R.id.snippet_docs)
        val urlDocs = itemView.findViewById<TextView>(R.id.url_article_docs)
        val cardView = itemView.findViewById<CardView>(R.id.card_view_search)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val docsList = docs[position]

        with(holder){
            cardView.tag = docsList
            urlDocs.text = docsList.urlArticle
            titleDocs.text = docsList.snippet
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_docs, parent,false)
        return NotificationRecyclerViewAdapter.ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return docs.size    }
}