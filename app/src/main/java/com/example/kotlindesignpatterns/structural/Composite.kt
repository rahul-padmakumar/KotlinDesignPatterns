package com.example.kotlindesignpatterns.structural

/**
 * Can be applied if the objects can be represented as tree structure
 */

interface Component{
    fun showPrice()
    fun getPrice(): Int
}

class IndividualComponent(private val name: String, private val price: Int): Component {
    override fun showPrice() {
        println("Price of $name is $price")
    }

    override fun getPrice() = price
}

class CompositeComponent(private val name: String): Component{

    private val individualComponents: MutableList<Component> = mutableListOf()

    fun addComponent(component: Component){
        individualComponents.add(component)
    }

    override fun showPrice() {
        println("*****************")
        println(name)
        individualComponents.forEach {
            it.showPrice()
        }
        println("**********************")
    }

    override fun getPrice(): Int = individualComponents.sumOf { it.getPrice() }
}

fun main(){

    val hdd = IndividualComponent("Hard disk", 2000)
    val ram = IndividualComponent("RAM", 1500)
    val processor = IndividualComponent("Intel", 10000)
    val mouse = IndividualComponent("Mouse", 200)
    val keyboard = IndividualComponent("Keyboard", 200)

    val motherBoard = CompositeComponent("Motherboard").apply {
        addComponent(ram)
        addComponent(processor)
    }

    val cabinet = CompositeComponent("Cabinet").apply {
        addComponent(motherBoard)
        addComponent(hdd)
    }

    val peripherals = CompositeComponent("Peripherals").apply {
        addComponent(mouse)
        addComponent(keyboard)
    }

    val computer = CompositeComponent("Computer").apply {
        addComponent(cabinet)
        addComponent(peripherals)
    }

    computer.showPrice()
    println(computer.getPrice())
}