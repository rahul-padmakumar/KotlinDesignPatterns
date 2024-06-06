package com.example.kotlindesignpatterns.creational.abstract_factory

/**
 * Mainly useful if we need to inject factory via DI
 *          OR
 * If we need to create a set of related objects for example - Car has engine object, tyre object, brakes object etc
 * abstract car factory has methods for creating engine, tyre, brake etc
 * FordCarFactory - creates concrete implementation based on their needs
 * FiatCarFactoru - creates concrete implementation based on their needs
 */

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