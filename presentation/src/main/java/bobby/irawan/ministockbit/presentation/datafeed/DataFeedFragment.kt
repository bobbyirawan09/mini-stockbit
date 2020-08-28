package bobby.irawan.ministockbit.presentation.datafeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import bobby.irawan.ministockbit.presentation.databinding.FragmentDataFeedBinding
import bobby.irawan.ministockbit.presentation.utils.Constants.BTC_SYMBOL
import bobby.irawan.ministockbit.presentation.utils.Constants.ETH_SYMBOL
import bobby.irawan.ministockbit.presentation.utils.NumberHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataFeedFragment : Fragment() {

    private var _binding: FragmentDataFeedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<DataFeedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.webSocketData.observe(viewLifecycleOwner) { data ->
            when (data.symbol) {
                BTC_SYMBOL -> binding.textViewPriceBtc.text =
                    NumberHelper.formatPrice(data.topTierFullVolume ?: 0.0)
                ETH_SYMBOL -> binding.textViewPriceEth.text =
                    NumberHelper.formatPrice(data.topTierFullVolume ?: 0.0)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}