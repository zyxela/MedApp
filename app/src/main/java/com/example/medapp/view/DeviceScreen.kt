
package com.example.medapp.view

import android.annotation.SuppressLint
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medapp.ui.components.AvailableDevice
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime300
import com.example.medapp.ui.theme.Lime800
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("MutableCollectionMutableState", "MissingPermission")
@Composable
fun DeviceScreen(viewModel: DeviceViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val bluetoothDevices by viewModel.bluetoothDevicesFlow.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.startScanning()
        CoroutineScope(Dispatchers.IO).launch {
            while (true){
                viewModel.refreshBluetoothDevices()
                delay(400)
            }
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
                        val device = bluetoothDevices[it].name?.toString() ?: bluetoothDevices[it].address
                        AvailableDevice(device) {

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