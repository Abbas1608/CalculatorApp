package com.example.calculator.Screen.Formula

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes


@Composable
fun FormulaListScreen(NavController: NavHostController)
{
    var context = LocalContext.current

    var FormulaList = listOf<String>(
        "Circle",
        "Cone",
        "Cube",
        "Cuboid",
        "Cylinder",
        "Ellipse",
        "Ellipsoid",
        "Rectangle",
        "Rhombus",
        "Square",
        "Sphere",
        "Triangle",
        "Triangle Prism",
        "Trapezoid",
        "Tetrahedron",
    )


    Column (
        modifier = Modifier.fillMaxSize()
    )
    {
        FormulaTopBar(NavController)

        LazyColumn{
            items(FormulaList) {

                Box (
                    modifier = Modifier
                        .clickable(onClick = {
                            NavController.navigate("${CalRoutes.FormulaScreen.name}/$it")
                            Toast.makeText(context,"$it", Toast.LENGTH_LONG).show()
                        })
                ){
                    Text(text = it,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top=10.dp, start = 20.dp)
                    )

                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}