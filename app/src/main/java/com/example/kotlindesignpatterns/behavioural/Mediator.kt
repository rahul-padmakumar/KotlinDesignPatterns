package com.example.kotlindesignpatterns.behavioural

/**
 * Mediator enables the decoupling of objects by introducing a layer in between so that the interaction between objects happens via the layer.
 * Real life example Air traffic control
 */

class ChatUser(private val mediator: Mediator, private val name: String){

    fun sendMessage(message: String){
        println("$name sending $message")
        mediator.sendMessage(this, message)
    }

    fun receiveMessage(message: String){
        println("$name received $message")
    }
}


class Mediator{

    private val usersList = mutableListOf<ChatUser>()

    fun sendMessage(user: ChatUser, message: String){
        usersList.filter {
            it != user
        }.forEach {
            it.receiveMessage(message)
        }
    }

    fun addUsers(chatUser: ChatUser): Mediator = apply { usersList.add(chatUser) }
}


fun main(){

    val mediator = Mediator()

    val alphaUser = ChatUser(mediator, "Alpha")
    val betaUser = ChatUser(mediator, "Beta")
    val gammaUser = ChatUser(mediator, "Gamma")

    mediator.addUsers(alphaUser)
        .addUsers(betaUser)
        .addUsers(gammaUser)

    alphaUser.sendMessage("Hi all")
    betaUser.sendMessage("Hi")
}
