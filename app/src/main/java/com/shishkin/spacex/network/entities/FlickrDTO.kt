package com.shishkin.spacex.network.entities

import com.google.gson.annotations.SerializedName

data class FlickrDTO(
	@SerializedName("original")
	val original: List<String>
)
