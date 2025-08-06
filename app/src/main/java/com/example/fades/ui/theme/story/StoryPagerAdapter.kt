package com.example.fades.ui.theme.story

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.example.fades.databinding.PageItemStoryBinding
import com.example.libfades.models.Image


class StoryPagerAdapter: ListAdapter<Image,StoryPagerAdapter.StoryPageViewHolder>(StoryPageDiffCallBack()) {

    class StoryPageViewHolder(val binding: PageItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

    private class StoryPageDiffCallBack(): DiffUtil.ItemCallback<Image>(){
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
        val image = getItem(position)
        val imageUrl = if (image.isAlbum == true && image.imagesCount != 0) {
            image.images?.get(0)?.link
        } else {
            image.link
        }
        imageUrl.let {
            holder.binding.storyViewPagerImageView.load(imageUrl)
            holder.binding.storyViewPagerTextview.text = imageUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(inflater,parent,false)
        return StoryPageViewHolder(binding)
    }

}