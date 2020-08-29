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

    protected val successSnackbar = MutableLiveData<String>()
    fun successSnackbar() = successSnackbar as LiveData<String>

    protected fun postSuccessSnackbar(message: String) {
        successSnackbar.postValue(message)
    }
}