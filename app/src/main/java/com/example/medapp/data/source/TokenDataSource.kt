package com.example.medapp.data.source

import android.content.SharedPreferences
import javax.inject.Inject

class TokenDataSource @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        private const val EMPTY_STRING = ""
        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        const val X_API_KEY = "fbcdd730ac35d24d4d7dc0341cb08417"
    }

    fun getJWT(): String {
        return prefs.getString(ACCESS_TOKEN, EMPTY_STRING).orEmpty()
    }

    fun setJWT(jwt: String) {
        prefs.edit().putString(ACCESS_TOKEN, jwt).apply()
    }
}