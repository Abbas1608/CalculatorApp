package com.example.calculator.Navigation

import androidx.compose.ui.graphics.painter.Painter

// 1 input
data class ShapeData1(
    val image: Painter,
    val text: String,
    val formula: String,
    val labelText: String
)

// for 2 input
data class ShapeData2(
    val image: Painter,
    val text: String,
    val formula: String,
    val labelText1: String,
    val labelText2: String,
)

// 3 input
data class ShapeData3(
    val image: Painter,
    val text: String,
    val formula: String,
    val labelText1: String,
    val labelText2: String,
    val labelText3: String
)