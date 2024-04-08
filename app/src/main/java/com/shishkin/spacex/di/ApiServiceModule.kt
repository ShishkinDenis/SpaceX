package com.shishkin.spacex.di

import com.shishkin.spacex.network.LaunchesApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** url нужно хранить локально в gradle.properties, тут должно быть BuildConfig.URL**/
private const val URL = "https://api.spacexdata.com"

@Module
class ApiServiceModule {

	@Singleton
	@Provides
	fun provideOkHttpClient(): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor().apply {
				level = HttpLoggingInterceptor.Level.BODY
			})
			.build()
	}

	@Singleton
	@Provides
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.baseUrl(URL)
			.addConverterFactory(GsonConverterFactory.create())
			.client(okHttpClient)
			.build()
	}

	@Singleton
	@Provides
	fun provideLaunchesApi(retrofit: Retrofit): LaunchesApi {
		return retrofit.create(LaunchesApi::class.java)
	}
}