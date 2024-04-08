package com.shishkin.spacex.ui.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.shishkin.spacex.R
import com.shishkin.spacex.databinding.FragmentLaunchesBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

const val LAUNCH_UI_TAG = "LAUNCH"

class LaunchesFragment : DaggerFragment() {

	@Inject
	lateinit var viewModelFactory: LaunchesViewModelFactory

	private val viewModel: LaunchesViewModel by viewModels { viewModelFactory }

	private lateinit var binding: FragmentLaunchesBinding

	private lateinit var launchesListAdapter: LaunchesListAdapter

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentLaunchesBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initLaunchesRecyclerView()
		lifecycleScope.launch {
			viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {

				launch {
					viewModel.getLaunches().collectLatest { launches ->
						launchesListAdapter.submitData(launches)
					}
				}
				launch {
					launchesListAdapter.loadStateFlow.collectLatest { loadStates ->
						binding.apply {
							progressBar.isVisible = loadStates.refresh is LoadState.Loading
							errorMessage.isVisible = loadStates.refresh is LoadState.Error
						}
					}
				}
			}
		}
	}

	private fun initLaunchesRecyclerView() {
		launchesListAdapter = LaunchesListAdapter(onClick = { launchUI ->
			findNavController().navigate(
				R.id.action_launchesFragment_to_launchDetailsFragment,
				bundleOf(LAUNCH_UI_TAG to launchUI)
			)
		})
		binding.rvLaunches.adapter = launchesListAdapter
	}
}