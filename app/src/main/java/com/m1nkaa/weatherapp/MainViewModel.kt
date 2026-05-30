package com.m1nkaa.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val api: WeatherApi = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    private val _weather = MutableLiveData<WeatherResponse?>()
    val weather: LiveData<WeatherResponse?> = _weather

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            _weather.value = null
            try {
                val result = api.getWeather(city, apiKey)
                _weather.value = result
            } catch (e: Exception) {
                _error.value = "Город не найден или нет интернета"
            } finally {
                _loading.value = false
            }
        }
    }
}