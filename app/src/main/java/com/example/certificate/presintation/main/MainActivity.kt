package com.example.certificate.presintation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.forEachIndexed
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.certificate.R
import com.example.certificate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navController get() = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navigation.setupWithNavController(navController)
            navigation.setOnItemSelectedListener {
                var index: Int = 0
                navigation.menu.forEachIndexed { itemIndex, item ->
                    if (it.itemId != item.itemId) return@forEachIndexed
                    index = itemIndex
                }
                NavigationUI.onNavDestinationSelected(it, navController)
                return@setOnItemSelectedListener true
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->

                navigation.isVisible =
                    listOf(
                        R.id.splashFragment,
                        R.id.detailFragment,
                        R.id.aboutFragment,
                        R.id.settingFragment
                    ).all {
                            it != destination.id
                        }
            }
        }
    }
}