package com.example.medapp.di

import com.example.medapp.data.repository.BluetoothRepository
import com.example.medapp.data.repositoryImpl.BluetoothRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {


    @Binds
    @ViewModelScoped
    fun getBluetoothRepository(repo: BluetoothRepositoryImpl): BluetoothRepository

}