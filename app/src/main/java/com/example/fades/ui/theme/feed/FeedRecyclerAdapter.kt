package com.example.fades.ui.theme.feed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
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
    ListAdapter<Image, FeedRecyclerAdapter.MyViewHolder>(FeedDiffCallBack()) {

    class  MyViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater,parent,false)
        return  MyViewHolder(binding)
    }


    private class  FeedDiffCallBack(): DiffUtil.ItemCallback<Image>() {
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem === newItem
        }

        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.ItemTextView.text = image.title

        val cover = image.cover
        val imgUrl = "https://i.imgur.com/${cover}.jpg"

        holder.binding.ItemImageView.load(imgUrl) {
            crossfade(true)
            placeholder(R.drawable.placeholder_image) // <-- You must provide a placeholder drawable
            error(R.drawable.placeholder_image)
        }
    }
}