package com.m1nkaa.weatherapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Вставь сюда свой API ключ с openweathermap.org
    private val API_KEY = "48290f0f8998b978845afd28844fa6d0"

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCity = findViewById<EditText>(R.id.editCity)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textCity = findViewById<TextView>(R.id.textCity)
        val textTemp = findViewById<TextView>(R.id.textTemp)
        val textDescription = findViewById<TextView>(R.id.textDescription)
        val textError = findViewById<TextView>(R.id.textError)

        buttonSearch.setOnClickListener {
            val city = editCity.text.toString().trim()
            if (city.isNotEmpty()) {
                viewModel.fetchWeather(city, API_KEY)
            } else {
                editCity.error = "Введи название города"
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.weather.observe(this) { weather ->
            if (weather != null) {
                textCity.text = weather.name
                textTemp.text = "${weather.main.temp.toInt()}°C"
                textDescription.text = weather.weather.firstOrNull()?.description ?: ""
                textError.visibility = View.GONE
                textCity.visibility = View.VISIBLE
                textTemp.visibility = View.VISIBLE
                textDescription.visibility = View.VISIBLE
            }
        }

        viewModel.error.observe(this) { error ->
            if (error != null) {
                textError.text = error
                textError.visibility = View.VISIBLE
                textCity.visibility = View.GONE
                textTemp.visibility = View.GONE
                textDescription.visibility = View.GONE
            }
        }
    }
}