package bobby.irawan.ministockbit.presentation.utils

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
object Constants {
    const val IS_USER_LOGIN = "IS_USER_LOGIN"
    const val SHARED_PREFERENCE_NAME = "UserPref"
    const val VIEW_TYPE_ITEM = 0
    const val VIEW_TYPE_LOADING = 1
    const val EMAIL = "email"
    const val BTC_SYMBOL = "BTC"
    const val ETH_SYMBOL = "ETH"

    sealed class LoginFlow {
        object LoginPage : LoginFlow()
        object HomePage : LoginFlow()
        object ForgetPinPage : LoginFlow()
    }
}