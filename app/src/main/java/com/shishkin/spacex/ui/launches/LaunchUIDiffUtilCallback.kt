package com.shishkin.spacex.ui.launches

import androidx.recyclerview.widget.DiffUtil
import com.shishkin.spacex.ui.entities.LaunchUI

class LaunchUIDiffUtilCallback : DiffUtil.ItemCallback<LaunchUI>() {

	override fun areItemsTheSame(oldItem: LaunchUI, newItem: LaunchUI): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: LaunchUI, newItem: LaunchUI): Boolean {
		return oldItem == newItem
	}
}