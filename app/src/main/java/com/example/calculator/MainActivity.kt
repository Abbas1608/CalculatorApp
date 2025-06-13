package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculator.Screen.AreaScreen.AreaListScreen
import com.example.calculator.Screen.CalulatorScreen.NormalCalculatorScreen
import com.example.calculator.Screen.Formula.FormulaListScreen
import com.example.calculator.Screen.SplitScreen.SplitScreen
import com.example.calculator.Screen.TipCal.TipMainContent
import com.example.calculator.ui.theme.CalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
//                HomeScreen()
               // FormulaListScreen()
                //AreaListScreen()
              //  SplitScreen()
              //  TipMainContent()
                NormalCalculatorScreen()
            }
        }
    }
}

