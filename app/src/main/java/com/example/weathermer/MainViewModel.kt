package com.example.weathermer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {
    val currentLD = MutableLiveData<String>()
    val listLD = MutableLiveData<String>()

}