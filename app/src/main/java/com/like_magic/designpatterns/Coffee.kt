package com.like_magic.designpatterns

class Coffee private constructor(builder:Builder) {

    private val doubleCoffee:Boolean
    private val milk:Boolean
    private val cream:Boolean
    private val sugar:Int
    private val cinnamon:Boolean
    private val syrup:String

    init {
        this.doubleCoffee = builder.doubleCoffee
        this.milk = builder.milk
        this.cream = builder.cream
        this.sugar = builder.sugar
        this.cinnamon = builder.cinnamon
        this.syrup = builder.syrup

    }

    fun getConsist():String{
        return "You make coffee: double coffee - $doubleCoffee, " +
                "milk - $milk, " +
                "cream - $cream, " +
                "sugar amount - $sugar, " +
                "cinnamon - $cinnamon, " +
                "syrup - $syrup"
    }

    class Builder {

        var doubleCoffee = false
        var milk = false
        var cream = false
        var sugar = 0
        var cinnamon = false
        var syrup = "without syrup"

        fun doubleCoffee() = apply{
            doubleCoffee = true
        }

        fun addMilk() = apply{
            milk = true
        }

        fun addCream() = apply{
            cream = true
        }

        fun addSugar(value:Int) = apply{
            sugar = value
        }

        fun addCinnamon() = apply{
            cinnamon = true
        }

        fun addSyrup(name:String) = apply{
            syrup = name
        }

        fun build():Coffee{
            return Coffee(this)
        }

    }

}