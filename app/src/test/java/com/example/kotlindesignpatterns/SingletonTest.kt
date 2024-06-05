package com.example.kotlindesignpatterns

import com.example.kotlindesignpatterns.creational.SingleInstance
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SingletonTest {
    @Test
    fun `test singleton`() {

        val obj1 = SingleInstance
        obj1.setName("Hello")
        val obj2 = SingleInstance
        assertEquals(obj1, obj2)
        assertEquals(obj2.getName(), "Hello")
    }
}