@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.example.medapp.view

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.medapp.ui.components.AvailableDevice
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime300
import com.example.medapp.ui.theme.Lime800

const val REQUEST_ENABLE_BT = 1

private fun startScanning(
    context: Context,
    receiver: BroadcastReceiver,
    bluetoothAdapter: BluetoothAdapter?
) {
    if (bluetoothAdapter != null && bluetoothAdapter.isEnabled) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            println("startScanning")
        }

        context.registerReceiver(
            receiver,
            IntentFilter(BluetoothDevice.ACTION_FOUND),
        )
        bluetoothAdapter.startDiscovery()
    }
}

private fun stopScanning(context: Context, receiver: BroadcastReceiver) {
    context.unregisterReceiver(receiver)
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun DeviceScreen() {

    val context = LocalContext.current
    val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

    val bluetoothAdapter = remember { bluetoothManager.adapter }
    var bluetoothDevices by remember { mutableStateOf(mutableListOf<BluetoothDevice>()) }

    val bluetoothReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action: String? = intent.action
            println(action)
            when (action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device: BluetoothDevice? =
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    bluetoothDevices = bluetoothDevices.apply { add(device!!) }
                    println(device!!.name)
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            Manifest.permission.BLUETOOTH_CONNECT
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        Log.e("onReceive", "onReceive")
                    }

                }
            }
        }

    }

    if (!bluetoothAdapter.isEnabled) {
        LaunchedEffect(Unit) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Log.e("enableBtIntent", "checkSelfPermission")

            }
            (context as? Activity)?.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        }
    } else {
        LaunchedEffect(Unit) {
            startScanning(context, bluetoothReceiver, bluetoothAdapter)
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp, 40.dp, 35.dp, 60.dp)
        ) {
            TitleText(text = "Devices", textColor = Lime800, shadowColor = Color.LightGray)

            Card(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(containerColor = Lime300)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    items(bluetoothDevices.size) {
                        AvailableDevice(bluetoothDevices[it].name) {

                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DeviceScreenPreview() {
    DeviceScreen()
}