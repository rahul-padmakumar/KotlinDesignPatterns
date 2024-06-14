package com.example.kotlindesignpatterns.behavioural

/**
 * Visitor - Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate
 * here Element is the type of object on which algorithm accepts
 */

interface Visitor<out R>{
    fun visit(fixedCostProject: FixedCostProject): R

    fun visit(timeAndMaterialProject: TimeAndMaterialProject): R

    fun visit(supportProject: SupportProject): R
}

interface Element{
    fun <R> accept(visitor: Visitor<R>): R
}

class FixedCostProject(val costPerMonth: Int): Element{
    override fun <R> accept(visitor: Visitor<R>): R = visitor.visit(this)
}

class TimeAndMaterialProject(val costPerHour: Int, val numberOfHours: Int): Element{
    override fun <R> accept(visitor: Visitor<R>): R = visitor.visit(this)

}

class SupportProject(val costPerYear: Int): Element{

    override fun <R> accept(visitor: Visitor<R>): R = visitor.visit(this)
}

class MonthlyCostCalculatorVisitor: Visitor<Int>{
    override fun visit(fixedCostProject: FixedCostProject) = fixedCostProject.costPerMonth

    override fun visit(timeAndMaterialProject: TimeAndMaterialProject): Int =
        timeAndMaterialProject.costPerHour * timeAndMaterialProject.numberOfHours

    override fun visit(supportProject: SupportProject): Int = supportProject.costPerYear/12
}

class AnnualCostCalculatorVisitor: Visitor<Int>{
    override fun visit(fixedCostProject: FixedCostProject): Int = fixedCostProject.costPerMonth * 12

    override fun visit(timeAndMaterialProject: TimeAndMaterialProject) = timeAndMaterialProject.costPerHour * timeAndMaterialProject.numberOfHours

    override fun visit(supportProject: SupportProject) = supportProject.costPerYear
}

fun main(){

    val fixedCostProject = FixedCostProject(1000)
    val timeAndMaterialProject = TimeAndMaterialProject(100, 12)
    val supportProject = SupportProject(12000)

    val monthlyCostCalculatorVisitor = MonthlyCostCalculatorVisitor()
    val annualCostCalculatorVisitor = AnnualCostCalculatorVisitor()

    val totalCostPerMonth = monthlyCostCalculatorVisitor.visit(fixedCostProject)+
            monthlyCostCalculatorVisitor.visit(timeAndMaterialProject) +
                monthlyCostCalculatorVisitor.visit(supportProject)
    println("Total cost per month: $totalCostPerMonth")

    val totalCostPerYear = annualCostCalculatorVisitor.visit(fixedCostProject)+
            annualCostCalculatorVisitor.visit(timeAndMaterialProject) +
            annualCostCalculatorVisitor.visit(supportProject)
    println("Total cost per year: $totalCostPerYear")
}