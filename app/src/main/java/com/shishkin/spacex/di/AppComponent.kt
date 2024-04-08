package com.shishkin.spacex.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AndroidSupportInjectionModule::class,
		ActivitiesModule::class,
		ApiServiceModule::class,
		RepositoryModule::class,
		LaunchesModule::class
	]
)
interface AppComponent : AndroidInjector<MyApplication> {

	@Component.Factory
	interface Factory {
		fun create(): AppComponent
	}
}
