package com.example.calculator.Screen.AreaScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.ShapeData
import com.example.calculator.ResultCard.singleInput
import com.example.calculator.R
@Composable
fun AreaCalScreen(NavController: NavHostController, shapeType: String)
{
   // val savedStateHandle = NavController.currentBackStackEntry?.savedStateHandle
    //val shapeType = savedStateHandle?.get<String>("shapeType") ?: ""

    // Define shape-specific data
    val shapeData = when(shapeType) {
        "Circle" -> ShapeData(
            image = painterResource(R.drawable.circle_image),
            formula = "π × r²",
            labelText = "Enter Radius"
        )
        "Square" -> ShapeData(
            image = painterResource(R.drawable.square),
            formula = "side²",
            labelText = "Enter Side Length"
        )
        "Rectangle" -> ShapeData(
            image = painterResource(R.drawable.cuboi_image),
            formula = "length × width",
            labelText = "Enter Length"
        )
        else -> ShapeData(
            image = painterResource(R.drawable.circle_image),
            formula = "π × r²",
            labelText = "Enter Radius"
        )
    }

    Column {
        AreaTopBar()
        singleInput(
            Image = shapeData.image,
            Text = shapeType,
            formula = shapeData.formula,
            labelText = shapeData.labelText
        )
    }
}