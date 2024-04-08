package com.shishkin.spacex.network

import com.shishkin.spacex.network.entities.LaunchDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface LaunchesApi {

    @GET("/v5/launches")
    suspend fun getLaunches(): List<LaunchDTO>

    @GET("/v5/launches")
    suspend fun getPaginationLaunches(@Query("page") page: Int): List<LaunchDTO>
}