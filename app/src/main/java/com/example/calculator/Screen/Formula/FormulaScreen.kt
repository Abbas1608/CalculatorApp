package com.example.calculator.Screen.Formula

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.ShapeData4
import com.example.calculator.R

@Composable
fun FormulaScreen(NavController: NavHostController, shapeType: String)
{
    val shapeData2 = when(shapeType) {
        "Circle" -> ShapeData4(
            image = painterResource(R.drawable.circle_image),
            text = "Area Of Circle",
            formula = "π × r²"
        )
        "Square" -> ShapeData4(
            image = painterResource(R.drawable.square_image),
            text = "Area Of Square",
            formula = "side²"
        )
        "Rectangle" -> ShapeData4(
            image = painterResource(R.drawable.rectangle_image),
            text = "Area Of Rectangle",
            formula = "length × width"
        )
        "Triangle" -> ShapeData4(
            image = painterResource(R.drawable.triangle_image),
            text = "Area Of Triangle",
            formula = "½ × base × height",
        )
        "Rhombus" -> ShapeData4(
            image = painterResource(R.drawable.rhombus_image),
            text = "Area Of Rhombus",
            formula = "½ × d1 x d2 ",
        )
        "Ellipse" -> ShapeData4(
            image = painterResource(R.drawable.ellipse_image),
            text = "Area Of Ellipse",
            formula = "π × R1 x R2 "
        )

        "Trapezoid" -> ShapeData4(
            image = painterResource(R.drawable.trapezoid_image),
            text = "Area Of Trapezoid",
            formula = "½ × (a + b) × h",
        )
        "Sphere" -> ShapeData4(
            image = painterResource(R.drawable.circle_image),
        text = "Volume Of Sphere",
        formula = "4/3 x π × R^3"
            )

        "Cube" -> ShapeData4(
            image = painterResource(R.drawable.cube_image),
            text = "Volume Of Cube",
            formula = "side^3"
        )

        "Tetrahedron" -> ShapeData4(
            image = painterResource(R.drawable.tetrahedron_image),
            text = "Volume Of Tetrahedron",
            formula = "a^3 / 6√2"
        )

        "Cone" -> ShapeData4(
            image = painterResource(R.drawable.cone_image),
            text = "Volume Of cone",
            formula = "1/3 x π x R^2 x H "
        )
        "Cylinder" -> ShapeData4(
            image = painterResource(R.drawable.cylinder_image),
            text = "Volume Of Cylinder",
            formula = "π x R^2 x H"
        )

        "Triangle Prism" -> ShapeData4(
            image = painterResource(R.drawable.triangle_prism_image),
            text = "Volume Of Triangle Prism",
            formula = "Area of base triangle x length of prism"
        )

        "Cuboid" -> ShapeData4(
            image = painterResource(R.drawable.cuboi_image),
            text = "Volume Of Cuboid",
            formula = "a x b x c"
        )

        "Ellipsoid" -> ShapeData4(
            image = painterResource(R.drawable.ellipsoid_image),
            text = "Volume Of Ellipsoid",
            formula = "4/3 x π x (R1 x R2 x R3)"
        )

        else -> ShapeData4(
            image = painterResource(R.drawable.tetrahedron_image),
            formula = "π × r²",
            text = "Area Of Circle"
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        FormulaScreenTopBar(NavController)
        displayScreen(
            Image = shapeData2.image,
            Typetext = shapeData2.text,
            formula = shapeData2.formula
        )
    }

}

@Composable
fun displayScreen(
    Image: Painter,
    Typetext: String,
    formula : String
)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(top = 20.dp)
    )
    {
        Image(
            painter = Image,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Formula:",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.Dark_Blue)
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = Typetext,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.Dark_Blue)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "= $formula",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.Dark_Blue)
        )
        Spacer(modifier = Modifier.height(20.dp))
    }

}