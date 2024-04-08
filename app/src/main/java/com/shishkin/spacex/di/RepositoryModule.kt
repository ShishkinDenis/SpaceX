package com.shishkin.spacex.di

import com.shishkin.spacex.network.LaunchesApi
import com.shishkin.spacex.repository.LaunchesRepositoryImpl
import com.shishkin.spacex.repository.LaunchesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

	@Provides
	fun provideLocationRepository(launchesApi: LaunchesApi): LaunchesRepository {
		return LaunchesRepositoryImpl(launchesApi)
	}
}