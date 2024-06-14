package com.example.kotlindesignpatterns.behavioural

/**
 * Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
 */

class Printer(private val formattingStrategy: (String) -> String){

    fun print(text: String) = println(formattingStrategy(text))
}

fun main(){

    val lowerCaseFormatting = {it: String -> it.lowercase()}
    val upperCaseFormatting = {it: String -> it.uppercase()}

    var printer = Printer(lowerCaseFormatting)
    printer.print("Hello, How ARE you?")
    printer = Printer(upperCaseFormatting)
    printer.print("Hello, How ARE you?")
}