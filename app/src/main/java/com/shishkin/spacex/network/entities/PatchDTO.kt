package com.shishkin.spacex.network.entities

import com.google.gson.annotations.SerializedName
import com.shishkin.spacex.ui.entities.PatchUI

data class PatchDTO(
	@SerializedName("small")
	val small: String,
	@SerializedName("large")
	val large: String
)

fun PatchDTO.toPatchUI(): PatchUI {
	return PatchUI(
		small = small,
		large = large
	)
}
