package bobby.irawan.ministockbit.presentation.wathclist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.usecase.GetCryptoUseCase
import bobby.irawan.ministockbit.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WatchListViewModel(
    private val getCryptoUseCase: GetCryptoUseCase
) : BaseViewModel() {

    private var isLoading = false
    private var page = 1
    var cryptoList: MutableList<CryptoModel> = mutableListOf()
        private set

    private var _cryptoData = MutableLiveData<SimpleResult<List<CryptoModel>>>(Result.State.Loading)
    val cryptoData = _cryptoData as LiveData<SimpleResult<List<CryptoModel>>>

    fun getCryptoData(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) onRefreshSetting()
            val request = CryptoRequest(page)
            val result = getCryptoUseCase.execute(request)
            delay(1200)
            _cryptoData.postValue(result)
            isLoading = false
        }
    }

    private fun onRefreshSetting() {
        page = 1
        cryptoList = mutableListOf()
    }

    fun fetchNextPage() {
        if (!isLoading) {
            isLoading = true
            getCryptoData()
        }
    }

    fun onUpdatePageNumber() {
        page++
    }

}