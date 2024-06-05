package com.example.kotlindesignpatterns.factory

import com.example.kotlindesignpatterns.creational.factory.DotMatrixPrinterType
import com.example.kotlindesignpatterns.creational.factory.InkjetPrinterType
import com.example.kotlindesignpatterns.creational.factory.PrinterFactory
import com.example.kotlindesignpatterns.creational.factory.PrinterType
import org.junit.Assert.assertEquals
import org.junit.Test

class FactoryTest {

    @Test
    fun `test factory`(){
        val laser = PrinterFactory.getPrinter(PrinterType.LaserPrinterType)
        val dotMatrixPrinter = PrinterFactory.getPrinter(DotMatrixPrinterType)
        val inkjet = PrinterFactory.getPrinter(InkjetPrinterType)
        assertEquals(inkjet.print("hi"), "_hi_")
        assertEquals(dotMatrixPrinter.print("hi"),".hi.")
        assertEquals(laser.print("hi"), ">hi<")
    }
}