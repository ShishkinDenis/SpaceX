package com.shishkin.spacex.ui.launches.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shishkin.spacex.network.LaunchesApi
import com.shishkin.spacex.network.entities.LaunchDTO


private const val STARTING_PAGE_INDEX = 1

class LaunchesPagingDataSource(private val launchesApi: LaunchesApi) :
	PagingSource<Int, LaunchDTO>() {

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LaunchDTO> {
		val pageNumber = params.key ?: STARTING_PAGE_INDEX
		return try {
			val response = launchesApi.getPaginationLaunches(pageNumber)
			LoadResult.Page(
				response,
				prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1,
				nextKey = if (response.isEmpty()) null else pageNumber + 1
			)
		} catch (e: Exception) {
			LoadResult.Error(e)
		}
	}

	override fun getRefreshKey(state: PagingState<Int, LaunchDTO>): Int? {
		return state.anchorPosition?.let { anchorPosition ->
			state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
				?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
		}
	}
}
