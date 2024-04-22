package com.example.medapp.data.repositoryImpl

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.example.medapp.data.repository.BluetoothRepository
import javax.inject.Inject

class BluetoothRepositoryImpl @Inject constructor(private val context: Context) :
    BluetoothRepository {
    private val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

    private val bluetoothAdapter = bluetoothManager.adapter
    private val bluetoothDevices = mutableListOf<BluetoothDevice>()

    private val bluetoothReceiver = object : BroadcastReceiver() {
        @SuppressLint("MissingPermission")
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device: BluetoothDevice? =
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    device?.let {
                        bluetoothDevices.add(it)
                        println(it.name)
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun startScanning() {
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled) {
            context.registerReceiver(bluetoothReceiver, IntentFilter(BluetoothDevice.ACTION_FOUND))
            bluetoothAdapter.startDiscovery()
        }
    }

    override fun stopScanning() {
        context.unregisterReceiver(bluetoothReceiver)
    }

    override fun getBluetoothDevices(): List<BluetoothDevice> {
        return bluetoothDevices
    }
}