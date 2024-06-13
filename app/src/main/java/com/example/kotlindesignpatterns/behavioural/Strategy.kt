package com.example.kotlindesignpatterns.behavioural

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