package bobby.irawan.ministockbit.presentation.utils

import bobby.irawan.ministockbit.presentation.utils.Constants.EMAIL
import bobby.irawan.ministockbit.presentation.utils.Constants.IS_USER_LOGIN

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
class UserManager(private val prefs: SharedPreferenceHelper) {

    var email = ""
        get() = if (field.isNotEmpty()) field else prefs.getString(EMAIL)
        set(value) {
            field = value
            prefs.save(EMAIL, value)
        }

    fun startUserSession() {
        prefs.save(IS_USER_LOGIN, true)
    }

    fun isSessionActive(): Boolean {
        return prefs.getBoolean(IS_USER_LOGIN)
    }

    fun endUserSession() {
        prefs.save(IS_USER_LOGIN, false)
    }
}