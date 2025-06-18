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
            text = "Area Of Circle",
            formula = "π × r²",
            labelText = "Enter Radius"
        )
        "Square" -> ShapeData1(
            image = painterResource(R.drawable.square),
            text = "Area Of Square",
            formula = "side²",
            labelText = "Enter Side Length"
        )
        "Rectangle" -> ShapeData2(
            image = painterResource(R.drawable.cuboi_image),
            text = "Area Of Rectangle",
            formula = "length × width",
            labelText1 = "Enter Length",
            labelText2 = "Enter Width"
        )
        "Triangle" -> ShapeData2(
            image = painterResource(R.drawable.triangle),
            text = "Area Of Triangle",
            formula = "½ × base × height",
            labelText1 = "Enter Base",
            labelText2 = "Enter Height"
        )
        "Rhombus" -> ShapeData2(
            image = painterResource(R.drawable.rhombus_image),
            text = "Area Of Rhombus",
            formula = "½ × d1 x d2 ",
            labelText1 = "Enter Diagonal 1",
            labelText2 = "Enter Diagonal 2 "
        )
        "Ellipse" -> ShapeData2(
            image = painterResource(R.drawable.ellipse_image),
            text = "Area Of Ellipse",
            formula = "π × R1 x R2 ",
            labelText1 = "Enter Radius 1",
            labelText2 = "Enter Radius 2 "
        )

        "Trapezoid" -> ShapeData3(
            image = painterResource(R.drawable.trapezoid),
            text = "Area Of Trapezoid",
            formula = "½ × (a + b) × h",
            labelText1 = "Enter Side A",
            labelText2 = "Enter Side B",
            labelText3 = "Enter Height"
        )
        else -> ShapeData1(
            image = painterResource(R.drawable.circle_image),
            formula = "π × r²",
            text = "Area Of Circle",
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
                    Typetext = shapeData.text,
                    formula = shapeData.formula,
                    labelText = shapeData.labelText
                )
            }
            is ShapeData2 -> {
                TwoInput(
                    Image = shapeData.image,
                    Text = shapeType,
                    Typetext = shapeData.text,
                    formula = shapeData.formula,
                    labelText1 = shapeData.labelText1,
                    labelText2 = shapeData.labelText2
                )
            }
            is ShapeData3 -> {
                ThreeInput(
                    Image = shapeData.image,
                    Text = shapeType,
                    Typetext = shapeData.text,
                    formula = shapeData.formula,
                    labelText1 = shapeData.labelText1,
                    labelText2 = shapeData.labelText2,
                    labelText3 = shapeData.labelText3
                )
            }
        }
    }
}