package com.example.kotlindesignpatterns.creational

object SingleInstance{

    private var name: String = ""

    fun setName(name: String){
        this.name = name
    }

    fun getName(): String = this.name
}