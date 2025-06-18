package com.example.calculator.Screen.AreaScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.ShapeData2
import com.example.calculator.Navigation.ShapeData1
import com.example.calculator.Navigation.ShapeData3
import com.example.calculator.ResultCard.singleInput
import com.example.calculator.R
import com.example.calculator.ResultCard.ThreeInput
import com.example.calculator.ResultCard.TwoInput

@Composable
fun AreaCalScreen(NavController: NavHostController, shapeType: String) {
    // Define shape-specific data
    val shapeData = when(shapeType) {
        "Circle" -> ShapeData1(
            image = painterResource(R.drawable.circle_image),
            formula = "π × r²",
            labelText = "Enter Radius"
        )
        "Square" -> ShapeData1(
            image = painterResource(R.drawable.square),
            formula = "side²",
            labelText = "Enter Side Length"
        )
        "Rectangle" -> ShapeData2(
            image = painterResource(R.drawable.cuboi_image),
            formula = "length × width",
            labelText1 = "Enter Length",
            labelText2 = "Enter Width"
        )
        "Triangle" -> ShapeData2(
            image = painterResource(R.drawable.triangle),
            formula = "½ × base × height",
            labelText1 = "Enter Base",
            labelText2 = "Enter Height"
        )
        "Trapezoid" -> ShapeData3(
            image = painterResource(R.drawable.trapezoid),
            formula = "½ × (a + b) × h",
            labelText1 = "Enter Side A",
            labelText2 = "Enter Side B",
            labelText3 = "Enter Height"
        )
        else -> ShapeData1(
            image = painterResource(R.drawable.circle_image),
            formula = "π × r²",
            labelText = "Enter Radius"
        )
    }

    Column {
        AreaCalTopBAr(NavController)

        // Conditional rendering based on shape data type
        when (shapeData) {
            is ShapeData1 -> {
                singleInput(
                    Image = shapeData.image,
                    Text = shapeType,
                    formula = shapeData.formula,
                    labelText = shapeData.labelText
                )
            }
            is ShapeData2 -> {
                TwoInput(
                    Image = shapeData.image,
                    Text = shapeType,
                    formula = shapeData.formula,
                    labelText1 = shapeData.labelText1,
                    labelText2 = shapeData.labelText2
                )
            }
            is ShapeData3 -> {
                ThreeInput(
                    Image = shapeData.image,
                    Text = shapeType,
                    formula = shapeData.formula,
                    labelText1 = shapeData.labelText1,
                    labelText2 = shapeData.labelText2,
                    labelText3 = shapeData.labelText3
                )
            }
        }
    }
}