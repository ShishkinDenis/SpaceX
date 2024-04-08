package com.shishkin.spacex.network.entities

import com.google.gson.annotations.SerializedName

data class LinksDTO(
	@SerializedName("patch")
	val patch: PatchDTO,
	@SerializedName("flickr")
	val flickr: FlickrDTO
)
