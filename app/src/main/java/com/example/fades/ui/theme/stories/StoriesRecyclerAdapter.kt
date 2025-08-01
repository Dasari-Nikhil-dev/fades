package com.example.fades.ui.theme.stories

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.example.fades.databinding.ListItemStoriesHeadBinding
import com.example.libfades.models.Tag

class StoriesRecyclerAdapter: ListAdapter<Tag,StoriesRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallBack()) {

    class StoriesViewHolder(storiesView: ListItemStoriesHeadBinding) : RecyclerView.ViewHolder(storiesView.root){
        val imageView :ImageView = storiesView.storiesHeadImageView
        val textView : TextView = storiesView.storiesHeadTextView
    }

   private class StoriesDiffCallBack: DiffUtil.ItemCallback<Tag>() {
        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val view = ListItemStoriesHeadBinding.inflate(inflater,parent,false)
        return StoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)
        holder.textView.text = tag.displayName
        holder.imageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
    }
}