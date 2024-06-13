package com.example.kotlindesignpatterns.behavioural

interface Command{
    fun execute()
}

interface Device{
    fun turnOn()
    fun turnOff()
}

class TurnOnCommand(private val device: Device): Command{
    override fun execute() {
        device.turnOn()
    }
}

class TurnOffCommand(private val device: Device): Command{
    override fun execute() {
        device.turnOff()
    }
}

class RemoteControl {

    private var command: Command? = null

    fun setCommand(command: Command){
        this.command = command
    }

    fun press(){
        command?.execute()
    }
}

class TV: Device{
    override fun turnOn() {
        println("Turn on TV")
    }

    override fun turnOff() {
        println("Turn off TV")
    }
}

class Radio: Device{
    override fun turnOn() {
        println("Turn on Radio")
    }

    override fun turnOff() {
        println("Turn off Radio")
    }
}

fun main(){
    val remoteControl = RemoteControl()

    val tv = TV()
    val radio = Radio()

    remoteControl.setCommand(TurnOnCommand(tv))
    remoteControl.press()
    remoteControl.setCommand(TurnOffCommand(tv))
    remoteControl.press()

    remoteControl.setCommand(TurnOnCommand(radio))
    remoteControl.press()
    remoteControl.setCommand(TurnOffCommand(radio))
    remoteControl.press()
}