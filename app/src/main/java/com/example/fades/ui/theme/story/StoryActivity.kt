package com.example.fades.ui.theme.story

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

    private var currentPage = 0
    private  var autoScrollHandler = Handler(Looper.getMainLooper())
    private lateinit var autoScrollRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")
        tagName?.let {
            storyViewModel.fetchTagsGallery(it)
        }
        binding.storyViewPager.adapter = storyAdapter
       autoScrollRunnable = object  : Runnable {
           override fun run() {
               val totalItems = storyAdapter.itemCount
               if (totalItems > 0) {
                   currentPage = (currentPage + 1) % totalItems
                   binding.storyViewPager.setCurrentItem(currentPage, true)
                   autoScrollHandler.postDelayed(this, 5000)
               }
           }

       }
    }

    override fun onResume() {
        super.onResume()
        storyViewModel.images.observe(this) {
            storyAdapter.submitList(it)
            currentPage = 0
            binding.storyViewPager.setCurrentItem(currentPage, false)
            autoScrollHandler.removeCallbacks(autoScrollRunnable)
            autoScrollHandler.postDelayed(autoScrollRunnable, 5000)
        }
    }
}