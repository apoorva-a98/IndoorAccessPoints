package com.example.indooraccesspointsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.indooraccesspointsandroid.ui.theme.IndoorAccessPointsandroidTheme
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            setContentView(R.layout.activity_main)
//            val wifiName = getWifiName(this)
//            Toast.makeText(this, "Connected to $wifiName", Toast.LENGTH_SHORT).show()

            IndoorAccessPointsandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}
private fun getWifiName(context: Context): String {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo

    if ((networkInfo != null) && (networkInfo.type == ConnectivityManager.TYPE_WIFI)) {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val connectionInfo = wifiManager.connectionInfo

        val bssid = connectionInfo.bssid
        val ssid = connectionInfo.ssid

        val wifiName = if (bssid != null && ssid != null) "$ssid ($bssid)" else ""
        println("Connected to: $wifiName")
        return wifiName
    }
    return ""
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IndoorAccessPointsandroidTheme {
        Greeting("Android")
    }
}