package com.shishkin.spacex.ui.launches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.shishkin.spacex.databinding.ItemLaunchBinding
import com.shishkin.spacex.ui.entities.LaunchUI

class LaunchesListAdapter(
	private val onClick: (item: LaunchUI) -> Unit
) : PagingDataAdapter<LaunchUI, LaunchViewHolder>(LaunchUIDiffUtilCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
		return LaunchViewHolder(
			binding = ItemLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false),
			onClick = onClick
		)
	}

	override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
		getItem(position)?.let { holder.bind(it) }
	}
}



