package com.example.calculator.Screen.TipCal



fun CalculateTotalTip(totalBill : Double, tipPercentage : Int): Double {

    if (totalBill > 1 && totalBill.toString().isNotEmpty())
    {
        return (totalBill * tipPercentage) / 100
    } else {
        return 0.0
    }

}

fun calculateTotalPerPerson(
    totalBill: Double,
    SplitBy : Int,
    tipPercentage: Int
): Double
{

    val Bill =
        CalculateTotalTip(totalBill,tipPercentage) + totalBill
    return (Bill / SplitBy)
}