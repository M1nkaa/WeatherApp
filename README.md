# 🌤 Weather App

An Android app that shows current weather for any city using the OpenWeatherMap API.

## 📸 Screenshots

| Home Screen | Weather Result |
|---|---|
| <img width="645" height="1357" alt="image" src="https://github.com/user-attachments/assets/a5c032dd-9138-41ec-9411-bd36f874c084" />
 | <img width="640" height="1354" alt="image" src="https://github.com/user-attachments/assets/7cf15811-1966-45af-be11-a488c9306c95" />
 |

## ✨ Features

- Search weather by city name
- Display temperature and weather description
- Error handling for invalid city or no internet
- Loading indicator during network requests

## 🛠 Tech Stack

- **Kotlin**
- **Retrofit2** — HTTP requests
- **Gson** — JSON parsing
- **ViewModel + LiveData** — MVVM architecture
- **Coroutines** — asynchronous operations
- **OpenWeatherMap API**

## 📁 Project Structure

```
app/src/main/
├── java/com/m1nkaa/weatherapp/
│   ├── MainActivity.kt        # UI and data observation
│   ├── MainViewModel.kt       # Business logic and API calls
│   ├── WeatherApi.kt          # Retrofit interface
│   └── WeatherResponse.kt     # Data models
└── res/
    └── layout/
        └── activity_main.xml
```

## ⚙️ Setup

1. Register at [openweathermap.org](https://openweathermap.org) and get a free API key
2. In `MainActivity.kt`, replace the placeholder:
```kotlin
private val API_KEY = "YOUR_API_KEY_HERE"
```

## ▶️ Getting Started

1. Clone the repository
```bash
git clone https://github.com/m1nkaa/WeatherApp.git
```
2. Open in **Android Studio**
3. Add your API key to `MainActivity.kt`
4. Run on an emulator or real device (API 24+)

## 📚 What I Learned

- **MVVM** architecture pattern
- Working with **REST API** via Retrofit
- **Coroutines** for async operations
- **LiveData** for reactive UI updates
- Network error handling
- Git flow: branches, commits, Pull Requests
