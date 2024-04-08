package com.shishkin.spacex.ui.launchdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.shishkin.spacex.R
import com.shishkin.spacex.databinding.FragmentLaunchDetailsBinding
import com.shishkin.spacex.ui.entities.LaunchUI
import com.shishkin.spacex.ui.launches.LAUNCH_UI_TAG
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LaunchesDetailsFragment : DaggerFragment() {

	@Inject
	lateinit var viewModelFactory: LaunchDetailsViewModelFactory
	private val viewModel: LaunchDetailsViewModel by viewModels { viewModelFactory }
	private lateinit var binding: FragmentLaunchDetailsBinding
	private lateinit var viewPagerAdapter: ImageSlideAdapter

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentLaunchDetailsBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setUpViews()
	}

	private fun setUpViews() {
		val launchUI: LaunchUI? = arguments?.getParcelable(LAUNCH_UI_TAG)
		binding.apply {
			nameTv.text = launchUI?.name
			dateTv.text = launchUI?.dateLocal
			detailsTv.text = launchUI?.details ?: context?.getString(R.string.empty_launch_details)
			launchUI?.sliderImages?.let {
				viewPagerAdapter = ImageSlideAdapter(requireContext(), it)
				viewpager.adapter = viewPagerAdapter
				indicator.setViewPager(binding.viewpager)
			}
		}
	}
}