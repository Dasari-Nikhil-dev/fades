package com.example.fades.ui.theme.story

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fades.R
import com.example.fades.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private  val storyViewModel by viewModels<StoryViewModel>()
    private  val storyAdapter = StoryPagerAdapter()
    private  lateinit var binding: ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")
        tagName?.let {
            storyViewModel.fetchTagsGallery(it)
        }
        binding.storyViewPager.adapter = storyAdapter
    }

    override fun onResume() {
        super.onResume()
        storyViewModel.images.observe(this) {
            storyAdapter.submitList(it)
        }
    }
}