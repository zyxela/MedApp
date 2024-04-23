package com.example.medapp.di

import com.example.medapp.data.repository.BluetoothRepository
import com.example.medapp.data.repository.LoginRepository
import com.example.medapp.data.repository.MedHistoryRepository
import com.example.medapp.data.repository.RegistrationRepository
import com.example.medapp.data.repository.UserRepository
import com.example.medapp.data.repository.VisitsRepository
import com.example.medapp.data.repositoryImpl.BluetoothRepositoryImpl
import com.example.medapp.data.repositoryImpl.LoginRepositoryImpl
import com.example.medapp.data.repositoryImpl.MedHistoryRepositoryImpl
import com.example.medapp.data.repositoryImpl.RegistrationRepositoryImpl
import com.example.medapp.data.repositoryImpl.UserRepositoryImpl
import com.example.medapp.data.repositoryImpl.VisitsRepositoryImpl
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
    fun getBluetoothRepository(repository: BluetoothRepositoryImpl): BluetoothRepository

    @Binds
    @ViewModelScoped
    fun getLoginRepository(repository: LoginRepositoryImpl): LoginRepository

    @Binds
    @ViewModelScoped
    fun getRegistrationRepository(repository: RegistrationRepositoryImpl): RegistrationRepository

    @Binds
    @ViewModelScoped
    fun getVisitsRepository(repository: VisitsRepositoryImpl): VisitsRepository

    @Binds
    @ViewModelScoped
    fun getUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    @ViewModelScoped
    fun getMedHistoryRepository(repository: MedHistoryRepositoryImpl): MedHistoryRepository

}