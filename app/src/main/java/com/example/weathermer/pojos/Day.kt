package com.example.weathermer.pojos

data class Day(
    val city: String,
    val date: String,
    val weatherCondition: String,
    val imageUrl: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val hoursWeatherJsonArr: String
)
