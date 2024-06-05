package com.example.kotlindesignpatterns.creational.factory

interface Printer {
    fun print(text: String): String
}

class DotMatrixPrinter: Printer{
    override fun print(text: String): String  = ".$text."
}

class InkjetPrinter: Printer{
    override fun print(text: String): String = "_${text}_"
}

class LaserPrinter: Printer{
    override fun print(text: String): String = ">${text}<"
}

sealed class PrinterType(){
    data object LaserPrinterType: PrinterType()
}

data object InkjetPrinterType : PrinterType()
data object DotMatrixPrinterType : PrinterType()

object PrinterFactory{
    fun getPrinter(printerType: PrinterType): Printer= when(printerType){
        DotMatrixPrinterType -> DotMatrixPrinter()
        InkjetPrinterType -> InkjetPrinter()
        PrinterType.LaserPrinterType -> LaserPrinter()
    }
}
