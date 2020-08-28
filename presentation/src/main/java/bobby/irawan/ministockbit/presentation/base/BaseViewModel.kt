package bobby.irawan.ministockbit.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bobby.irawan.ministockbit.domain.common.SimpleError
import bobby.irawan.ministockbit.domain.common.SimpleResult

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
abstract class BaseViewModel : ViewModel() {

    protected val snackbar = MutableLiveData<String>()
    fun snackbarMessage() = snackbar as LiveData<String>

    protected val successSnackbar = MutableLiveData<String>()
    fun successSnackbar() = successSnackbar as LiveData<String>

    protected val errorSnackbar = MutableLiveData<String>()
    fun errorSnackbar() = errorSnackbar as LiveData<String>

    protected fun postSnackbar(message: String) {
        snackbar.postValue(message)
    }

    protected fun postSuccessSnackbar(message: String) {
        successSnackbar.postValue(message)
    }

    protected fun postErrorSnackbar(message: String) {
        errorSnackbar.postValue(message)
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