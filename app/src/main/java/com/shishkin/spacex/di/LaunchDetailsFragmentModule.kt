package com.shishkin.spacex.di

import com.shishkin.spacex.ui.launchdetails.LaunchesDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LaunchDetailsFragmentModule {

    @ContributesAndroidInjector
    abstract fun provideLaunchDetailsFragment(): LaunchesDetailsFragment
}