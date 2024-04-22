package com.example.medapp.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SourceModule {
    companion object {
        private const val PREFS_KEY = "prefs_key"
    }

    @Provides
    @Singleton
    fun providePrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    }


}