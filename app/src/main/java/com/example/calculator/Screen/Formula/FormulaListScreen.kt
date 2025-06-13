package com.example.calculator.Screen.Formula

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun FormulaListScreen()
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
        "Parallelogram",
        "Regular Ploygon",
        "Rectangle",
        "Rhombus",
        "Square Pyramid"
    )


    Column (
        modifier = Modifier.fillMaxSize()
    )
    {
        FormulaTopBar()

        Spacer(modifier = Modifier.height(15.dp) )


        LazyColumn(
        ) {
            items(FormulaList) {


                Text(text = it,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top=10.dp, start = 20.dp)
                        .clickable(onClick = {
                            Toast.makeText(context,"$it", Toast.LENGTH_LONG).show()
                        }))


                HorizontalDivider()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}