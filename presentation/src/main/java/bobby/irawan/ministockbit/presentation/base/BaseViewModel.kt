package bobby.irawan.ministockbit.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bobby.irawan.ministockbit.domain.common.SimpleError
import bobby.irawan.ministockbit.domain.common.SimpleResult

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
abstract class BaseViewModel: ViewModel() {

    protected val snackbarMessage = MutableLiveData<String>()
    fun snackbarMessage() = snackbarMessage as LiveData<String>

    protected val pageLoading = MutableLiveData<Boolean>()
    fun pageLoading() = pageLoading as LiveData<Boolean>

    protected fun postSnackbar(message: String) {
        snackbarMessage.postValue(message)
    }

    protected fun setSnackbar(message: String) {
        snackbarMessage.value = message
    }

    protected fun postLoading(show: Boolean) {
        pageLoading.postValue(show)
    }

    protected inline fun <T> SimpleResult<T>.handleSimpleResult(
        crossinline onSuccessData: (T) -> Unit = {},
        crossinline onSuccessNoData: () -> Unit = {},
        crossinline onFailure: (SimpleError) -> Unit = {}
    ) {
        this.handleResult(
            successDataBlock = { onSuccessData(it) },
            successNoDataBlock = { onSuccessNoData() },
            failureBlock = { onFailure(it) }
        )
    }
}