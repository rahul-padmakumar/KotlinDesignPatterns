package com.example.kotlindesignpatterns.behavioural

//Momento
class DocumentMemento(private val content: String){
    fun getContent(): String = content
}

//Originator
class Document{
    private var content: String = ""

    fun write(content: String){
        this.content = content
    }

    fun getContent() = content

    fun createMemento(): DocumentMemento = DocumentMemento(content)

    fun restoreFromMemento(memento: DocumentMemento){
        this.content = memento.getContent()
    }
}

//Caretaker
class History{
    private val mementos = mutableListOf<DocumentMemento>()

    fun storeContent(documentMemento: DocumentMemento){
        mementos.add(documentMemento)
    }

    fun restoreContent(index: Int): DocumentMemento = mementos[index]
}

fun main(){
    val document = Document()
    val history = History()

    document.write("Content version 1")
    history.storeContent(document.createMemento())
    println(document.getContent())

    document.write("Content version 2")
    history.storeContent(document.createMemento())
    println(document.getContent())

    document.restoreFromMemento(history.restoreContent(1))
    println(document.getContent())

    document.restoreFromMemento(history.restoreContent(0))
    println(document.getContent())
}

