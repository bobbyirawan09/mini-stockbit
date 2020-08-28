package bobby.irawan.ministockbit.presentation.main

import bobby.irawan.ministockbit.presentation.base.BaseViewModel
import bobby.irawan.ministockbit.presentation.utils.UserManager

/**
 * Created by bobbyirawan09 on 28/08/20.
 */
class MainActivityViewModel(private val userManager: UserManager) : BaseViewModel() {

    fun onUserSignOut() {
        userManager.endUserSession()
        postSuccessSnackbar("Success logout")
    }

}