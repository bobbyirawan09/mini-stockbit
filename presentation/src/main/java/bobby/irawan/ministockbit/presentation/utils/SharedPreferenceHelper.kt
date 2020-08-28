package bobby.irawan.ministockbit.presentation.utils

import android.content.SharedPreferences

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
class SharedPreferenceHelper(private val pref: SharedPreferences) {

    private val editor = pref.edit()

    fun save(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun save(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean = pref.getBoolean(key, false)

    fun getString(key: String): String = pref.getString(key, "").orEmpty()

    fun remove(key: String) {
        editor.remove(key)
        editor.apply()
    }

}