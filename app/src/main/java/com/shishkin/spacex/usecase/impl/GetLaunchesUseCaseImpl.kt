package com.shishkin.spacex.usecase.impl

import androidx.paging.PagingData
import androidx.paging.map
import com.shishkin.spacex.network.entities.toLaunchUI
import com.shishkin.spacex.repository.LaunchesRepository
import com.shishkin.spacex.ui.entities.LaunchUI
import com.shishkin.spacex.usecase.GetLaunchesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/** Здесь должна быть более сложная бизнес логика, например работа с несколькими репозиториями **/

class GetLaunchesUseCaseImpl @Inject constructor(private val launchesRepository: LaunchesRepository) :
	GetLaunchesUseCase {

	override fun invoke(): Flow<PagingData<LaunchUI>> = launchesRepository.getLaunches()
		.map { pagingData -> pagingData.map { launchDTO -> launchDTO.toLaunchUI() } }
}