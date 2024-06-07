package com.example.kotlindesignpatterns.creational


class AlertBox{
    var message: String? = null

    fun show(){
        println(message)
    }
}

class Window{

    private val alertBox by lazy { AlertBox() }

    fun showMessage(message: String){
        alertBox.message = message
        alertBox.show()
    }
}

class VariableWindow{
    private lateinit var alertBox: AlertBox

    fun prepare(){
        alertBox = AlertBox()
    }

    fun showMessage(message: String){
        if(::alertBox.isInitialized) {
            alertBox.message = message
            alertBox.show()
        } else {
            println("Not initialized")
        }
    }
}

fun main(){
    val window = Window()
    window.showMessage("hello")

    val variableWindow = VariableWindow()
    variableWindow.showMessage("hello")
    variableWindow.prepare()
    variableWindow.showMessage("Hello after init")
}