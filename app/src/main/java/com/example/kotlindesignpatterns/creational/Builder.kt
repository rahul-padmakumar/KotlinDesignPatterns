package com.example.kotlindesignpatterns.creational

class FoodOrder private constructor(builder: Builder) {
    private var bread: String? = null
    private var curry: String? = null
    private var soups: String? = null
    private var desserts: String? = null
    private var platters: String? = null

    class Builder() {
        var bread: String? = null
            private set
        var curry: String? = null
            private set
        var soups: String? = null
            private set
        var desserts: String? = null
            private set
        var platters: String? = null
            private set

        fun setBread(value: String): Builder = this.apply { bread = value }
        fun setCurry(value: String): Builder = this.apply { curry = value }
        fun setSoups(value: String): Builder = this.apply { soups = value }
        fun setDesserts(value: String): Builder = this.apply { desserts = value }
        fun setPlatters(value: String): Builder = this.apply { platters = value }

        fun build(): FoodOrder = FoodOrder(this)
    }

    init {
        bread = builder.bread
        curry = builder.curry
        desserts = builder.desserts
        soups = builder.soups
        platters = builder.platters
    }
}

fun main(){

    val foodOrder = FoodOrder.Builder()
        .setSoups("SweetCornChickenSoup")
        .setBread("Plain Naan")
        .setCurry("Paneer Butter Masala")

    println(foodOrder.bread)
    println(foodOrder.curry)
    println(foodOrder.soups)
}
