package com.like_magic.designpatterns

import kotlin.random.Random
import java.util.Timer
import java.util.TimerTask

interface WeatherObserver {
    fun onWeatherChange(weatherData: WeatherData)
}

data class WeatherData(var temperature: Double, var humidity: Double, var pressure: Int)

object WeatherSubject {
    private val observers = mutableListOf<WeatherObserver>()

    fun getInstance():WeatherSubject {
        return this
    }

    fun addObserver(observer: WeatherObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: WeatherObserver) {
        observers.remove(observer)
    }

    fun notifyObservers(weatherData: WeatherData) {
        observers.forEach { it.onWeatherChange(weatherData) }
    }

    fun startPeriodicUpdates() {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val temperature = Random.nextDouble(20.0, 25.0)
                val humidity = Random.nextDouble(0.8, 0.99)
                val pressure = Random.nextInt(740, 780)
                val weatherData = WeatherData(temperature, humidity, pressure)
                notifyObservers(weatherData)
            }
        }, 0, 5000)
    }
}