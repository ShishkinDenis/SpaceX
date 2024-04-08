package com.shishkin.spacex.network.entities

import com.google.gson.annotations.SerializedName
import com.shishkin.spacex.ui.entities.LaunchUI
import com.shishkin.spacex.util.toUIDate

data class LaunchDTO(
	@SerializedName("id")
	val id: String,
	@SerializedName("name")
	val name: String,
	@SerializedName("links")
	val links: LinksDTO,
	@SerializedName("date_local")
	val dateLocal: String,
	@SerializedName("details")
	val details: String?
)

fun LaunchDTO.toLaunchUI(): LaunchUI {
	return LaunchUI(
		id = id,
		name = name,
		image = links.patch.small,
		dateLocal = dateLocal.toUIDate(),
		details = details,
		sliderImages = links.flickr.original
	)
}

