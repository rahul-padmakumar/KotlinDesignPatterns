package com.example.kotlindesignpatterns.creational

abstract class Shape: Cloneable{
    abstract fun draw()

    public override fun clone(): Any {
        var clone: Any? = null
        try {
            clone = super.clone()
        } catch (e: CloneNotSupportedException){
            e.printStackTrace()
        }
        return clone!!
    }
}

class Rectangle: Shape(){
    override fun draw() {
        println("Rectangle")
    }
}

class Circle: Shape(){
    override fun draw() {
        println("Circle")
    }
}

object ShapeCache{

    private val cacheMap: MutableMap<Int, Shape> = mutableMapOf()

    fun loadCache(){
        cacheMap[1] = Rectangle()
        cacheMap[2] = Circle()
    }

    fun getCache(id: Int): Shape? = cacheMap[id]?.clone() as? Shape
}

fun main(){
    ShapeCache.loadCache()
    ShapeCache.getCache(1)?.draw()
    ShapeCache.getCache(2)?.draw()
}