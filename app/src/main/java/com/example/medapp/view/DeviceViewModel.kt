package com.example.medapp.view

import android.bluetooth.BluetoothDevice
import androidx.lifecycle.ViewModel
import com.example.medapp.data.repository.BluetoothRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DeviceViewModel @Inject constructor(private val repository: BluetoothRepository) : ViewModel() {
    private val _bluetoothDevicesFlow = MutableStateFlow<List<BluetoothDevice>>(emptyList())
    val bluetoothDevicesFlow: StateFlow<List<BluetoothDevice>> = _bluetoothDevicesFlow


    fun startScanning(){
        repository.startScanning()
    }

    fun stopScanning(){
        repository.stopScanning()
    }

    fun refreshBluetoothDevices() {
        _bluetoothDevicesFlow.value = repository.getBluetoothDevices()
    }
}