package com.example.kotlindesignpatterns.behavioural

interface Observer<T> {
    fun update(eventType: String, value: T)
}

class EventManager(vararg operations: String){
    private var observerMap = hashMapOf<String, MutableList<Observer<String>>>()

    init {
        operations.forEach {
            observerMap[it] = mutableListOf()
        }
    }

    fun subscribe(eventType: String, observer: Observer<String>) =
        observerMap[eventType]?.add(observer)

    fun unSubscribe(eventType: String, observer: Observer<String>) =
        observerMap[eventType]?.remove(observer)

    fun notify(eventType: String, value: String){
        observerMap[eventType]?.forEach {
            it.update(eventType, value)
        }
    }
}

class AppendListener: Observer<String>{
    override fun update(eventType: String, value: String) {
        println("Update Listener Event $eventType and value $value")
    }
}

class UpdateListener: Observer<String>{
    override fun update(eventType: String, value: String) {
        println("Update listener Event $eventType and value $value")
    }
}

fun main(){

    val eventManager = EventManager("append", "update")
    val updateListener = UpdateListener()
    eventManager.subscribe("append", AppendListener())
    eventManager.subscribe("update", updateListener)

    eventManager.notify("append", "a")
    eventManager.notify("update", "hello")

    eventManager.unSubscribe("update", updateListener)

    eventManager.notify("append", "a")
    eventManager.notify("update", "hello")
}



