package com.example.calculator.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.calculator.Screen.AreaScreen.AreaCalScreen
import com.example.calculator.Screen.AreaScreen.AreaListScreen
import com.example.calculator.Screen.CalulatorScreen.NormalCalculatorScreen
import com.example.calculator.Screen.Formula.FormulaListScreen
import com.example.calculator.Screen.HomeScreen.HomeScreen
import com.example.calculator.Screen.SplitScreen.SplitScreen
import com.example.calculator.Screen.TipCal.TipMainContent
import com.example.calculator.Screen.Volume.VolumeCalScreen
import com.example.calculator.Screen.Volume.VolumeListScreen

@Composable
fun CalNavigation() {
    val NavController = rememberNavController()

    // SplitScreen
    NavHost(
        navController = NavController,
        startDestination = CalRoutes.SplitScreen.name
    ) {

        // SplitScreen
        composable(CalRoutes.SplitScreen.name) {
            SplitScreen(NavController)
        }

        // HomeScreen
        composable(CalRoutes.HomeScreen.name) {
            HomeScreen(NavController)
        }


        // Calculator Screen
        composable(CalRoutes.NormalCalculatorScreen.name) {
                NormalCalculatorScreen(NavController)
            }

        // Area
        composable(CalRoutes.AreaListScreen.name) {
                AreaListScreen(NavController)
            }


        // Volume
        composable(CalRoutes.VolumeListScreen.name) {
                VolumeListScreen(NavController)
            }

        // Formula
        composable (CalRoutes.FormulaScreen.name){
            FormulaListScreen(NavController)
        }
        // Tip Calculator
        composable (CalRoutes.TipCalculator.name){
            TipMainContent(NavController)
        }

        composable(
            route = "${CalRoutes.AreaCalScreen.name}/{shapeType}",
            arguments = listOf(navArgument("shapeType") { type = NavType.StringType })
        ) { backStackEntry ->
            val shapeType = backStackEntry.arguments?.getString("shapeType") ?: "Circle"
            AreaCalScreen(NavController, shapeType)
        }

        composable(
            route = "${CalRoutes.VolumeCalScreen.name}/{shapeType}",
            arguments = listOf(navArgument("shapeType") { type = NavType.StringType })
        ) { backStackEntry ->
            val shapeType = backStackEntry.arguments?.getString("shapeType") ?: "Circle"
            VolumeCalScreen(NavController,shapeType)
        }
    }
}