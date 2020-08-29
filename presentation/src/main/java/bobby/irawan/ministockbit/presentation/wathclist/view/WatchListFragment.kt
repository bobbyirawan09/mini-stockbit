package bobby.irawan.ministockbit.presentation.wathclist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
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
                viewModel.cryptoList.addAll(data)
                adapter.submitList(viewModel.cryptoList)
                viewModel.onUpdatePageNumber()
                onFinishLoadData()
                binding.recyclerViewCryptoData.setVisible()
            }, {
                stopShimmer()
                onFinishLoadData()
            }, {
                stopShimmer()
                showErrorSnackbar(it.errorMessage)
                onFinishLoadData()
            }
        ) { state ->
            when (state) {
                Result.State.Loading -> {
                    onLoadData()
                }
            }
        }
    }

    private fun onFinishLoadData() {
        binding.progressBarLoadMore.hideSlideDown()
        binding.pullToRefresh.isRefreshing = false
        binding.textViewErrorMessage.showIf { viewModel.cryptoList.isNullOrEmpty() }
    }

    private fun onLoadData() {
        startShimmer()
        binding.textViewErrorMessage.setGone()
        binding.recyclerViewCryptoData.setGone()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}