package com.example.kotlindesignpatterns.creational.abstract_factory

interface AlertDialog{
    fun show()
}

class MaterialAlertDialog: AlertDialog{
    override fun show() {
        println("Material_alert_dialog")
    }
}

class CupertinoAlertDialog: AlertDialog{
    override fun show() {
        println("Cupertino_alert_dialog")
    }
}

interface AlertDialogFactory{
    fun createDialog(): AlertDialog
}

class MaterialAlertDialogFactory: AlertDialogFactory{
    override fun createDialog(): AlertDialog = MaterialAlertDialog()
}

class CupertinoAlertDialogFactory: AlertDialogFactory{
    override fun createDialog(): AlertDialog = CupertinoAlertDialog()
}

fun main() {
    var dialogFactory: AlertDialogFactory = MaterialAlertDialogFactory()
    dialogFactory.createDialog().show()

    dialogFactory = CupertinoAlertDialogFactory()
    dialogFactory.createDialog().show()
}