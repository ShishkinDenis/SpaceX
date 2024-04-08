package com.shishkin.spacex.ui.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaunchUI(
    val id: String,
    val name: String,
    val image: String?,
    val dateLocal: String,
    val details: String?,
    val sliderImages: List<String>
): Parcelable


