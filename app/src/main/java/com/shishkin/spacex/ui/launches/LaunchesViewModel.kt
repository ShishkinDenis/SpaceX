package com.shishkin.spacex.ui.launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shishkin.spacex.ui.entities.LaunchUI
import com.shishkin.spacex.usecase.GetLaunchesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchesViewModel @Inject constructor(
	private val getLaunchesUseCase: GetLaunchesUseCase
) : ViewModel() {

	init {
		getLaunches()
	}

	fun getLaunches(): Flow<PagingData<LaunchUI>> {
		return getLaunchesUseCase().cachedIn(viewModelScope)
	}
}
