package com.shishkin.spacex.di

import com.shishkin.spacex.ui.launches.LaunchesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LaunchesFragmentModule {

    @ContributesAndroidInjector()
    abstract fun provideLaunchesFragment(): LaunchesFragment
}