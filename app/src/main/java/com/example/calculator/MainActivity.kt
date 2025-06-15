package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.Screen.CalulatorScreen.CalculatorViewMode
import com.example.calculator.Screen.CalulatorScreen.NormalCalculatorScreen
import com.example.calculator.ui.theme.CalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val calviewmodle = ViewModelProvider(owner = this)[CalculatorViewMode::class.java]
            CalculatorTheme {
//                HomeScreen()
               // FormulaListScreen()
                //AreaListScreen()
              //  SplitScreen()
              //  TipMainContent()
                NormalCalculatorScreen(calviewmodle)
            }
        }
    }
}

