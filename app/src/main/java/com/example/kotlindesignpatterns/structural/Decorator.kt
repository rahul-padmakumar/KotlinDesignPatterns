package com.example.kotlindesignpatterns.structural

/**
 * Similar to extension feature in Kotlin to add functionality to existing classes
 */

interface CoffeeMachine{
    fun makeCoffee()
}

class NormalCoffeeMachine: CoffeeMachine{
    override fun makeCoffee() {
        println("Making coffee")
    }
}

class EspressoMachine(private val normalCoffeeMachine: NormalCoffeeMachine): CoffeeMachine by normalCoffeeMachine{
    fun makeEspressoCoffee(){
        println("Making espresso coffee")
    }
}

fun main(){
    val normalCoffeeMachine = NormalCoffeeMachine()
    val espressoMachine = EspressoMachine(normalCoffeeMachine)
    espressoMachine.makeCoffee()
    espressoMachine.makeEspressoCoffee()
}