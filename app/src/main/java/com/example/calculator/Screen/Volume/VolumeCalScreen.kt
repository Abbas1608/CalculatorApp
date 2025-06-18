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
            text = "Volume Of Sphere",
            formula = "4/3 x π × R^3",
            labelText = "Enter Radius"
        )

        "Cube" -> ShapeData1(
            image = painterResource(R.drawable.cube_image),
            text = "Volume Of Cube",
            formula = "side^3",
            labelText = "Enter Side Length"
        )

        "Tetrahedron" -> ShapeData1(
            image = painterResource(R.drawable.triangle),
            text = "Volume Of Tetrahedron",
            formula = "a^3 / 6√2",
            labelText = "Enter Edge"
        )

        "Cone" -> ShapeData2(
            image = painterResource(R.drawable.cone_image),
            text = "Volume Of cone",
            formula = "1/3 x π x R^2 x H ",
            labelText1 = "Enter Radius",
            labelText2 = "Enter Height"
        )
        "Cylinder" -> ShapeData2(
            image = painterResource(R.drawable.cylinder_image),
            text = "Volume Of Cylinder",
            formula = "π x R^2 x H",
            labelText1 = "Enter Radius",
            labelText2 = "Enter Height"
        )

        "Triangle_Prism" -> ShapeData2(
            image = painterResource(R.drawable.triangle_prism),
            text = "Volume Of Triangle Prism",
            formula = "Area of base triangle x length of prism",
            labelText1 = "Enter Area of triangle",
            labelText2 = "Enter Length of prism"
        )

        "Cuboid" -> ShapeData3(
            image = painterResource(R.drawable.cuboi_image),
            text = "Volume Of Cuboid",
            formula = "a x b x c",
            labelText1 = "Enter Side A",
            labelText2 = "Enter Side B",
            labelText3 = "Enter Side C"
        )

        "Ellipsoid" -> ShapeData3(
            image = painterResource(R.drawable.ellipsoid_image),
            text = "Volume Of Ellipsoid",
            formula = "4/3 x π x (R1 x R2 x R3)",
            labelText1 = "Enter Radius1",
            labelText2 = "Enter Radius2",
            labelText3 = "Enter Radius3"
        )

        else -> ShapeData1(
            image = painterResource(R.drawable.cube_image),
            text = "Volume Of Cube",
            formula = "side^3",
            labelText = "Enter Length"
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