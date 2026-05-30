# 🌤 Weather App

Приложение для просмотра текущей погоды по названию города.

## 📸 Скриншоты

| Главный экран | Результат поиска |
|---|---|
| _скриншот сюда_ | _скриншот сюда_ |

## 🚀 Функциональность

- Поиск погоды по названию города
- Отображение температуры, описания погоды
- Обработка ошибок (неверный город, нет интернета)
- Индикатор загрузки во время запроса

## 🛠 Стек технологий

- **Kotlin**
- **Retrofit2** — HTTP-запросы к API
- **Gson** — парсинг JSON
- **ViewModel + LiveData** — архитектура MVVM
- **Coroutines** — асинхронные запросы
- **OpenWeatherMap API**

## 📁 Структура проекта

```
app/src/main/
├── java/com/m1nkaa/weatherapp/
│   ├── MainActivity.kt        # UI и наблюдение за данными
│   ├── MainViewModel.kt       # Бизнес-логика, запросы к API
│   ├── WeatherApi.kt          # Retrofit интерфейс
│   └── WeatherResponse.kt     # Модели данных
└── res/
    └── layout/
        └── activity_main.xml
```

## ⚙️ Настройка

1. Зарегистрируйся на [openweathermap.org](https://openweathermap.org) и получи API ключ
2. В файле `MainActivity.kt` замени значение:
```kotlin
private val API_KEY = "ВАШ_API_КЛЮЧ"
```

## ▶️ Запуск

1. Клонируй репозиторий
```bash
git clone https://github.com/m1nkaa/WeatherApp.git
```
2. Открой в **Android Studio**
3. Добавь свой API ключ в `MainActivity.kt`
4. Запусти на эмуляторе или реальном устройстве (API 24+)

## 📚 Чему научилась

- Архитектура **MVVM** (Model-View-ViewModel)
- Работа с **REST API** через Retrofit
- **Coroutines** для асинхронных операций
- **LiveData** для реактивного обновления UI
- Обработка сетевых ошибок
- Git flow: ветки, коммиты, Pull Requests
