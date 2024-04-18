package com.example.medapp.data.repository

import android.bluetooth.BluetoothDevice

interface BluetoothRepository {
    fun startScanning()
    fun stopScanning()
    fun getBluetoothDevices(): List<BluetoothDevice>
}