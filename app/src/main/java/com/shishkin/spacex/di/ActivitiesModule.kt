package com.shishkin.spacex.di

import com.shishkin.spacex.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(
        modules = [
            LaunchesFragmentModule::class,
            LaunchDetailsFragmentModule::class,
        ]
    )
    abstract fun provideMainActivity(): MainActivity
}

