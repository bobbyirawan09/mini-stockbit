package bobby.irawan.ministockbit.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bobby.irawan.ministockbit.presentation.base.BaseViewModel
import bobby.irawan.ministockbit.presentation.utils.Constants.LoginFlow
import bobby.irawan.ministockbit.presentation.utils.UserManager

class LoginViewModel(private val userManager: UserManager) :
    BaseViewModel() {

    private var _loginFlow = MutableLiveData<LoginFlow>()
    val loginFlow = _loginFlow as LiveData<LoginFlow>

    init {
        onCheckUserAuth()
    }

    private fun onCheckUserAuth() {
        if (userManager.isSessionActive()) {
            navigate(LoginFlow.HomePage)
        } else {
            userManager.endUserSession()
            navigate(LoginFlow.LoginPage)
        }
    }

    fun navigate(flow: LoginFlow) {
        _loginFlow.postValue(flow)
    }

    fun onUserLogin(email: String) {
        userManager.startUserSession()
        userManager.email = email.orEmpty()
        postSuccessSnackbar("Success login")
        navigate(LoginFlow.HomePage)
    }
}