package com.shishkin.spacex.usecase

import androidx.paging.PagingData
import com.shishkin.spacex.ui.entities.LaunchUI
import kotlinx.coroutines.flow.Flow

interface GetLaunchesUseCase {
	operator fun invoke(): Flow<PagingData<LaunchUI>>
}