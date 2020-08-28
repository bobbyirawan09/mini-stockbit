package bobby.irawan.ministockbit.presentation.wathclist.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.presentation.R
import bobby.irawan.ministockbit.presentation.databinding.FragmentWatchListBinding
import bobby.irawan.ministockbit.presentation.utils.*
import bobby.irawan.ministockbit.presentation.wathclist.adapter.WatchListAdapter
import bobby.irawan.ministockbit.presentation.wathclist.viewmodel.WatchListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchListFragment : Fragment() {

    private var _binding: FragmentWatchListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<WatchListViewModel>()
    private lateinit var adapter: WatchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentWatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpObserver()
        setUpListener()
        viewModel.getCryptoData()
    }

    private fun setUpView() {
        with(binding) {
            recyclerViewCryptoData.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = WatchListAdapter {
                viewModel.fetchNextPage()
                progressBarLoadMore.showSlideUp()
            }
            recyclerViewCryptoData.adapter = adapter
        }
    }

    private fun setUpObserver() {
        viewModel.cryptoData.observe(viewLifecycleOwner, ::handleCryptoResult)
    }

    private fun handleCryptoResult(result: SimpleResult<List<CryptoModel>>) {
        result.handleResult(
            { data ->
                stopShimmer()
                binding.progressBarLoadMore.hideSlideDown()
                adapter.submitList(data)
                val isRefreshState = binding.pullToRefresh.isRefreshing
                viewModel.onUpdatePageNumber(isRefreshState)
                binding.pullToRefresh.isRefreshing = false
                binding.recyclerViewCryptoData.setVisible()
            }, {
                stopShimmer()
                binding.progressBarLoadMore.hideSlideDown()
                binding.pullToRefresh.isRefreshing = false
                binding.textViewErrorMessage.setVisible()
            }, {
                stopShimmer()
                binding.progressBarLoadMore.hideSlideDown()
                binding.pullToRefresh.isRefreshing = false
                binding.textViewErrorMessage.setVisible()
                showErrorSnackbar(it.errorMessage)
            }
        ) { state ->
            when (state) {
                Result.State.Loading -> {
                    startShimmer()
                    binding.textViewErrorMessage.setGone()
                    binding.recyclerViewCryptoData.setGone()
                }
            }
        }
    }

    private fun stopShimmer() {
        binding.shimmerLoading.stopShimmer()
        binding.shimmerLoading.setGone()
    }

    private fun startShimmer() {
        binding.shimmerLoading.setVisible()
        binding.shimmerLoading.startShimmer()
    }

    private fun setUpListener() {
        binding.pullToRefresh.setOnRefreshListener {
            binding.textViewErrorMessage.setGone()
            binding.recyclerViewCryptoData.setGone()
            startShimmer()
            adapter.submitList(null)
            viewModel.getCryptoData(true)
        }
    }

    private fun showErrorSnackbar(message: String) {
        val view = requireActivity().findViewById(android.R.id.content) as View
        view.showErrorSnackbar(message)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.sign_out) {
            viewModel.onSignOutUser()
            val action =
                WatchListFragmentDirections.actionWatchListFragmentToLoginFragment()
            findNavController().navigate(action)
            return true
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}