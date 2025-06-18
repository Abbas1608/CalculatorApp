package com.example.calculator.Screen.Volume

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.ShapeData1
import com.example.calculator.Navigation.ShapeData2
import com.example.calculator.Navigation.ShapeData3
import com.example.calculator.R
import com.example.calculator.ResultCard.ThreeInput
import com.example.calculator.ResultCard.TwoInput
import com.example.calculator.ResultCard.singleInput
import com.example.calculator.Screen.AreaScreen.AreaCalTopBAr

@Composable
fun VolumeCalScreen(NavController: NavHostController, shapeType: String)
{
    // Define shape-specific data
    val shapeData = when(shapeType) {
        "Sphere" -> ShapeData1(
            image = painterResource(R.drawable.circle_image),
            formula = "4/3 x π × R^3",
            labelText = "Enter Radius"
        )

        "Cube" -> ShapeData1(
            image = painterResource(R.drawable.cube_image),
            formula = "side^3",
            labelText = "Enter Side Length"
        )

        "Tetrahedron" -> ShapeData1(
            image = painterResource(R.drawable.triangle),
            formula = "a^3 / 6√2",
            labelText = "Enter Edge"
        )

        "Cone" -> ShapeData2(
            image = painterResource(R.drawable.cone_image),
            formula = "1/3 x π x R^2 x H ",
            labelText1 = "Enter Radius",
            labelText2 = "Enter Height"
        )
        "Cylinder" -> ShapeData2(
            image = painterResource(R.drawable.cylinder_image),
            formula = "π x R^2 x H",
            labelText1 = "Enter Radius",
            labelText2 = "Enter Height"
        )

        "Triangle_Prism" -> ShapeData2(
            image = painterResource(R.drawable.triangle_prism),
            formula = "Area of base triangle x length of prism",
            labelText1 = "Enter Area of triangle",
            labelText2 = "Enter Length of prism"
        )

        "Cuboid" -> ShapeData3(
            image = painterResource(R.drawable.cuboi_image),
            formula = "a x b x c",
            labelText1 = "Enter Side A",
            labelText2 = "Enter Side B",
            labelText3 = "Enter Side C"
        )
        else -> ShapeData1(
            image = painterResource(R.drawable.circle_image),
            formula = "π × r²",
            labelText = "Enter Radius"
        )
    }

    Column {
        VolumeCalTopBar(NavController)

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