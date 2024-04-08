package com.shishkin.spacex.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.shishkin.spacex.R
import com.shishkin.spacex.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		val navHostFragment =
			supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
		val navController = navHostFragment.navController
		NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
	}
}