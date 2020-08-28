package bobby.irawan.ministockbit.presentation.wathclist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.presentation.R
import bobby.irawan.ministockbit.presentation.databinding.ItemWatchListBinding
import bobby.irawan.ministockbit.presentation.utils.NumberHelper
import bobby.irawan.ministockbit.presentation.utils.addPrefix
import bobby.irawan.ministockbit.presentation.utils.changeTextColor

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
class WatchListAdapter(
    private val onBottomReached: () -> Unit
) : ListAdapter<CryptoModel, RecyclerView.ViewHolder>(CryptoItemDiffCallback()) {

    private var cryptoItem = mutableListOf<CryptoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemWatchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun submitList(list: List<CryptoModel>?) {
        super.submitList(if (list != null) list else null);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(getItem(position))
        }
        if (position == itemCount - 1) {
            onBottomReached()
        }
    }

    inner class ItemViewHolder(private val binding: ItemWatchListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoModel: CryptoModel) {
            with(binding) {
                textViewCode.text = cryptoModel.name
                textViewCompanyName.text = cryptoModel.fullName
                textViewPriceChange.changeTextColor(cryptoModel.changePrice, itemView.context)
                textViewPrice.text = NumberHelper.formatPrice(cryptoModel.currentPrice)
                val changePercentage =
                    NumberHelper.formatPriceChanges(cryptoModel.changePricePercent).addPrefix()
                val changePrice =
                    NumberHelper.formatPriceChanges(cryptoModel.changePrice).addPrefix()
                textViewPriceChange.text =
                    itemView.context.getString(R.string.changes_info, changePrice, changePercentage)
            }
        }
    }

    class CryptoItemDiffCallback : DiffUtil.ItemCallback<CryptoModel>() {
        override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
            return oldItem == newItem
        }
    }
}
