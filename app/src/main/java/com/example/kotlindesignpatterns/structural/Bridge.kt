package com.example.kotlindesignpatterns.structural

interface Material{
    fun material()
}

interface Furniture{
    fun build()
}

class Wood: Material{
    override fun material() {
        println("Wood")
    }
}

class Metal: Material{
    override fun material() {
        println("Metal")
    }
}

class Chair(private val material: Material): Furniture{
    override fun build() {
        material.material()
        println("Chair is build")
    }
}

class Table(private val material: Material): Furniture{
    override fun build() {
        material.material()
        println("table is build")
    }
}

fun main(){
    Chair(Wood()).build()
    Table(Metal()).build()
}

