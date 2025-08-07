package com.example.fades.ui.theme.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.ImageRequest
import com.example.fades.R
import com.example.fades.databinding.ActivityMainBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val storiesViewModel by viewModels<HomeViewModel>()
    private val storiesAdapter = StoriesRecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1️⃣ Inflate via ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNav()

        binding.storiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            adapter = storiesAdapter
        }

        storiesViewModel.fetchTags()

    }

    fun setUpNav() {
        // 2️⃣ Find the NavHostFragment and get its NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        /*  Not using an Action bar in our app Now
        ------------Action Bar Code-------------------
           // 2️⃣ Set up toolbar as support ActionBar
          setSupportActionBar(binding.toolbar)

        // 4️⃣ AppBarConfiguration with top-level destinations
          val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_hot, R.id.navigation_top))
          setupActionBarWithNavController(navController, appBarConfiguration)
          ------------Action Bar Code-------------------
          */


        // 3️⃣ Hook up your BottomNavigationView
        binding.bottomNav.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this) {
            it.forEach { tag ->
                val url = "https://i.imgur.com/${tag.backgroundHash}.jpg"
                val request = ImageRequest.Builder(this)
                    .data(url)
                    .size(60,60)
                    .build()
                imageLoader.enqueue(request)
            }
            storiesAdapter.submitList(it)
        }
    }
}