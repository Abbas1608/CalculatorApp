package com.example.calculator.Navigation

import androidx.compose.ui.graphics.painter.Painter
import com.example.calculator.Screen.AreaScreen.AreaListScreen
import com.example.calculator.Screen.CalulatorScreen.NormalCalculatorScreen

enum class CalRoutes {

    SplitScreen,
    HomeScreen,
    NormalCalculatorScreen,
    AreaListScreen,
    VolumeListScreen,
    FormulaListScreen,
    TipCalculator,
    AreaCalScreen,
    VolumeCalScreen,
    FormulaScreen,
    CgpaScreen;
    companion object{
        fun fromRoutes(routes: String?): CalRoutes
        = when(routes?.substringBefore("/"))
        {
            SplitScreen.name ->SplitScreen
            HomeScreen.name -> HomeScreen
            NormalCalculatorScreen.name -> NormalCalculatorScreen
            AreaListScreen.name -> AreaListScreen
            VolumeListScreen.name -> VolumeListScreen
            FormulaListScreen.name -> FormulaListScreen
            FormulaScreen.name -> FormulaScreen
            TipCalculator.name -> TipCalculator
            AreaCalScreen.name -> AreaCalScreen
            VolumeCalScreen.name -> VolumeCalScreen
            CgpaScreen.name -> CgpaScreen
            null -> NormalCalculatorScreen
            else ->throw IllegalArgumentException("Routes unExcepted")
        }
    }
}