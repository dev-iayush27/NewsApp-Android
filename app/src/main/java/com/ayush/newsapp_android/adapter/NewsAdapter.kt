package com.ayush.newsapp_android.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayush.newsapp_android.*
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context, private val news: NewsModel): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news.articles[position])
    }

    override fun getItemCount(): Int {
        return news.articles.size
    }

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.news_title)
        private val publishedDate: TextView = itemView.findViewById(R.id.publishedDate)
        private val newsImage: ImageView = itemView.findViewById(R.id.item_image)

        fun bind(model: Article) {
            title.text = model.title
            publishedDate.text = convertDate(model.publishedAt, "dd MMM, yyyy hh:mm a")
            Glide.with(newsImage)
                .load(model.urlToImage)
                .into(newsImage)

            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(itemView.context, NewsDetailActivity::class.java)
                )
            }
        }
    }
}