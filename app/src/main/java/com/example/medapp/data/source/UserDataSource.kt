package com.example.medapp.data.source

import android.content.SharedPreferences
import javax.inject.Inject

class UserDataSource @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        private const val EMPTY_STRING = ""
        private const val USER_ID = "USER_ID"
        private const val EMAIL = "EMAIL"
        private const val PASSWORD = "PASSWORD"
    }

    fun setUserId(userId: Int) {
        prefs.edit().putInt(USER_ID, userId).apply()
    }

    fun setPassword(password: String) {
        prefs.edit().putString(PASSWORD, password).apply()

    }

    fun setEmail(email: String) {
        prefs.edit().putString(EMAIL, email).apply()
    }


    fun getUserId(): Int {
        return prefs.getInt(USER_ID, -1)
    }

    fun getEmail(): String {
        return prefs.getString(EMAIL, EMPTY_STRING).orEmpty()
    }

    fun getPassword(): String {
        return prefs.getString(PASSWORD, EMPTY_STRING).orEmpty()
    }


}