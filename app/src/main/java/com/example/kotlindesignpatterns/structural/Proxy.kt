package com.example.kotlindesignpatterns.structural

/**
 * Similar to facade but proxy controls lifecycle of the real object
 */
interface Image{
    fun show(fileName: String)
}

class RealImage(): Image{

    init {
        println("Initializing real image")
    }
    override fun show(fileName: String) {
        println("Show real image: $fileName")
    }
}

class ProxyImage: Image{
    private var realImage: RealImage? = null
    override fun show(fileName: String) {
        if(realImage == null){
            realImage = RealImage()
        }
        realImage?.show(fileName)
    }
}

fun main(){
    val proxyImage = ProxyImage()
    proxyImage.show("Hello.jpeg")
    proxyImage.show("Test.jpeg")
}
