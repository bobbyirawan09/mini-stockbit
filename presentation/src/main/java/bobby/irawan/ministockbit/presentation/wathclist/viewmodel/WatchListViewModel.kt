package bobby.irawan.ministockbit.presentation.wathclist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bobby.irawan.ministockbit.domain.common.Result
import bobby.irawan.ministockbit.domain.common.SimpleResult
import bobby.irawan.ministockbit.domain.model.CryptoModel
import bobby.irawan.ministockbit.domain.model.CryptoRequest
import bobby.irawan.ministockbit.domain.usecase.GetCryptoUseCase
import bobby.irawan.ministockbit.domain.usecase.GetWebSocketUseCase
import bobby.irawan.ministockbit.presentation.base.BaseViewModel
import bobby.irawan.ministockbit.presentation.utils.UserManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WatchListViewModel(
    private val getCryptoUseCase: GetCryptoUseCase,
    private val userManager: UserManager
) : BaseViewModel() {

    private var isLoading = false
    private var page = 1
    private var cryptoList: MutableList<CryptoModel> = mutableListOf()

    private var _cryptoData = MutableLiveData<SimpleResult<List<CryptoModel>>>(Result.State.Loading)
    val cryptoData = _cryptoData as LiveData<SimpleResult<List<CryptoModel>>>

    fun getCryptoData(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) page = 1
            val request = CryptoRequest(page)
            val result = getCryptoUseCase.execute(request)
            _cryptoData.postValue(result)
            isLoading = false
        }
    }

    fun fetchNextPage() {
        if (!isLoading) {
            isLoading = true
            getCryptoData()
        }
    }

    fun onUpdatePageNumber(isRefresh: Boolean) {
        if (!isRefresh) {
            page++
        } else {
            page = 1
        }
    }

    fun onSignOutUser() {
        userManager.endUserSession()
    }

}