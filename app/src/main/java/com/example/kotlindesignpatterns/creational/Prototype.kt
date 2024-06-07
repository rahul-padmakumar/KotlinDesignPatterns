package com.example.kotlindesignpatterns.creational

/**
 * For creating new instances of complex objects that require minor changes
 * data class copy is an example of prototype
 */
data class Person(
    val name: String,
    val age: Int
)

fun main(){
    val person = Person("test1", 15)
    val person2 = person.copy(name = "test2")
    println(person2)
}
