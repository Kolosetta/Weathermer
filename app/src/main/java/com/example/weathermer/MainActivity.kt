package com.example.weathermer

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weathermer.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "8995eaf91b534d3a886154816222412"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            getData("Moscow")
        }
    }

    private fun getData(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
        url,
        {
            val obj = JSONObject(it)
            val temp = obj.getJSONObject("current").getString("temp_c")
            Log.i("Response", "Response is: $it")
            Log.i("Temp", "Temp is: $temp")
        },
        {
            Log.e("Error", "Network error: $it")
        })
        queue.add(stringRequest)
    }
}