package com.shishkin.spacex.ui.launchdetails

import com.shishkin.spacex.ui.base.BaseViewModelFactory
import javax.inject.Inject

class LaunchDetailsViewModelFactory @Inject constructor() :
	BaseViewModelFactory<LaunchDetailsViewModel>(LaunchDetailsViewModel::class.java) {

	override fun createViewModel(): LaunchDetailsViewModel = LaunchDetailsViewModel()
}


