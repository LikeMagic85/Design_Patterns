package com.like_magic.designpatterns

import android.util.Log

class DeliveryMethodFactory(
    private val name: String,
    private val maxWeight: Int,
    private val maxSize: Int
) {
    fun createDeliveryMethod(country: String): DeliveryMethod? {
        return when (country) {
            "Belarus" -> TruckDelivery(name, maxWeight, maxSize)
            "USA" -> ShipDelivery(name, maxWeight, maxSize)
            "Germany" -> AirDelivery(name, maxWeight, maxSize)
            "Russia" -> TrainDelivery(name, maxWeight, maxSize)
            else -> null
        }
    }
}

class TruckDelivery(
    private val name: String,
    private val maxWeight: Int,
    private val maxSize: Int
) : DeliveryMethod {
    override fun deliver() {
        Log.d(
            "@@@",
            "Delivering by truck. Company name: $name." +
                    " Max weight: $maxWeight." +
                    " Max size: $maxSize"
        )
    }
}

class ShipDelivery(
    private val name: String,
    private val maxWeight: Int,
    private val maxSize: Int,
    var type:String = "By sea"
) : DeliveryMethod {
    override fun deliver() {
        Log.d(
            "@@@",
            "Delivering by ship $type. Company name: $name." +
                    " Max weight: $maxWeight." +
                    " Max size: $maxSize"
        )
    }
}

class AirDelivery(
    private val name: String,
    private val maxWeight: Int,
    private val maxSize: Int,
    private val type:String = "passenger"
) : DeliveryMethod {
    override fun deliver() {
        Log.d(
            "@@@",
            "Delivering by plane, type: $type. Company name: $name." +
                    " Max weight: $maxWeight." +
                    " Max size: $maxSize"
        )
    }
}

class TrainDelivery(
    private val name: String,
    private val maxWeight: Int,
    private val maxSize: Int,
    private val trackSize:Int = 1000
) : DeliveryMethod {
    override fun deliver() {
        Log.d(
            "@@@",
            "Delivering by train, track size: $trackSize. Company name: $name." +
                    " Max weight: $maxWeight." +
                    " Max size: $maxSize"
        )
    }
}

interface DeliveryMethod {
    fun deliver()
}