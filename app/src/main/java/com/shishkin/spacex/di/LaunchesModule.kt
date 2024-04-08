package com.shishkin.spacex.di

import com.shishkin.spacex.repository.LaunchesRepository
import com.shishkin.spacex.usecase.GetLaunchesUseCase
import com.shishkin.spacex.usecase.impl.GetLaunchesUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LaunchesModule {

	@Provides
	@Singleton
	fun provideGetDishForCrownsWithBalanceUseCase(
		launchesRepository: LaunchesRepository,
	): GetLaunchesUseCase = GetLaunchesUseCaseImpl(launchesRepository)
}