package com.example.kotlindesignpatterns.structural

/**
 * Most popular example is RecyclerView Adapter - Convert data to view
 */

interface ThreePinSocket{
    fun acceptThreePinPlug()
}

class TwoPinPLug{
    fun insertTwoPinPlug(){
        println("Inserted two pin plug")
    }
}

class ThreePinAdapter(private val twoPinPLug: TwoPinPLug): ThreePinSocket{
    override fun acceptThreePinPlug() {
        twoPinPLug.insertTwoPinPlug()
        println("Adapter made it possible to plug two pin into three pin socket")
    }
}

fun main(){
    val twoPinPLug = TwoPinPLug()
    ThreePinAdapter(twoPinPLug).acceptThreePinPlug()
}