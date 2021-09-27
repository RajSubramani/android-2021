package com.raj.androidfeatures.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raj.androidfeatures.R
import com.raj.androidfeatures.databinding.NewsListItemBinding
import com.raj.androidfeatures.pojo.NewsArticle

class NewsAdapter : ListAdapter<NewsArticle, NewsViewHolder>(DIFF_NEWS) {


    companion object {
        val DIFF_NEWS = object : DiffUtil.ItemCallback<NewsArticle>() {
            override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(NewsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NewsViewHolder(private val newsListItemBinding: NewsListItemBinding) :
    RecyclerView.ViewHolder(newsListItemBinding.root) {
    fun bind(newsArticle: NewsArticle) {
        newsListItemBinding.apply {
            newsTitle.text = newsArticle.title
            Glide.with(itemView).load(newsArticle.url).error(R.drawable.image_placeholder)
                .into(newsImage)
        }

    }
}