package com.shishkin.spacex.ui.launches

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shishkin.spacex.R
import com.shishkin.spacex.databinding.ItemLaunchBinding
import com.shishkin.spacex.ui.entities.LaunchUI

class LaunchViewHolder(
	private val binding: ItemLaunchBinding,
	private val onClick: (item: LaunchUI) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(item: LaunchUI) {
		with(binding) {
			nameTv.text = item.name
			dateTv.text = item.dateLocal

			Glide.with(root.context)
				.load(item.image)
				.placeholder(R.mipmap.ic_rocket_round)
				.error(R.mipmap.ic_rocket_round)
				.into(imageIv)

			root.setOnClickListener {
				onClick.invoke(item)
			}
		}
	}
}