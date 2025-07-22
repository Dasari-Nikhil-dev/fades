package com.example.fades

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fades.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1️⃣ Inflate via ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2️⃣ Set up toolbar as support ActionBar
        setSupportActionBar(binding.toolbar)


        // 2️⃣ Find the NavHostFragment and get its NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        // 4️⃣ AppBarConfiguration with top-level destinations
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_hot, R.id.navigation_top))

        setupActionBarWithNavController(navController, appBarConfiguration)

        // 3️⃣ Hook up your BottomNavigationView
        binding.bottomNav.setupWithNavController(navController)
    }
}