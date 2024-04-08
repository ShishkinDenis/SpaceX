package com.shishkin.spacex.ui.launches

import com.shishkin.spacex.ui.base.BaseViewModelFactory
import com.shishkin.spacex.usecase.GetLaunchesUseCase
import javax.inject.Inject

class LaunchesViewModelFactory @Inject constructor(
	private val getLaunchesUseCase: GetLaunchesUseCase
) :
	BaseViewModelFactory<LaunchesViewModel>(LaunchesViewModel::class.java) {

	override fun createViewModel(): LaunchesViewModel = LaunchesViewModel(
		getLaunchesUseCase = getLaunchesUseCase
	)
}