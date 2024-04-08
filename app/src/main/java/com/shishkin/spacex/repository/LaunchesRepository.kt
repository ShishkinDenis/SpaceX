package com.shishkin.spacex.repository

import androidx.paging.PagingData
import com.shishkin.spacex.network.entities.LaunchDTO
import kotlinx.coroutines.flow.Flow

interface LaunchesRepository {
	fun getLaunches(): Flow<PagingData<LaunchDTO>>
}