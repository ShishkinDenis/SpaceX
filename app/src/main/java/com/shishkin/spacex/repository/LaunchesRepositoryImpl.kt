package com.shishkin.spacex.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shishkin.spacex.network.LaunchesApi
import com.shishkin.spacex.network.entities.LaunchDTO
import com.shishkin.spacex.ui.launches.pagination.LaunchesPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

const val NETWORK_PAGE_SIZE = 10

class LaunchesRepositoryImpl @Inject constructor(private val launchesApi: LaunchesApi) :
	LaunchesRepository {

	override fun getLaunches(): Flow<PagingData<LaunchDTO>> {
		return Pager(
			config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, prefetchDistance = 2),
			pagingSourceFactory = {
				LaunchesPagingDataSource(launchesApi)
			}
		).flow
	}
}


