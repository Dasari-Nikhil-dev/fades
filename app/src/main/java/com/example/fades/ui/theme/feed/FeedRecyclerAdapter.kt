package com.example.fades.ui.theme.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.crossfade
import coil3.request.error
import coil3.request.placeholder
import com.example.fades.R
import com.example.fades.databinding.ListItemGalleryImageBinding
import com.example.libfades.models.Image

class FeedRecyclerAdapter() :
    ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    class FeedViewHolder(itemView: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(itemView.root){
        val textview : TextView = itemView.ItemTextView
        val imageView : ImageView = itemView.ItemImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater,parent,false)
        return  FeedViewHolder(binding)
    }

    private class FeedDiffCallBack: DiffUtil.ItemCallback<Image>() {
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
           return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
       val image = getItem(position)
        holder.textview.text = image.title
        holder.imageView.load("https://i.imgur.com/${image.cover}.jpg") {
            crossfade(true)
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_image)
        }
    }
}