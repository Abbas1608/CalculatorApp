package com.example.calculator.Screen.AreaScreen

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.VCard
import com.example.calculator.R

@Preview(showSystemUi = true)
@Composable
fun AreaListScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AreaTopBar()

        LazyColumn {
            item {
                Row {
                    VCard(painterResource(R.drawable.cricle), "Circle")
                    VCard(painterResource(R.drawable.rhombus), "Rhombus")
                }

                Row {
                    VCard(painterResource(R.drawable.square), "Square")
                    VCard(painterResource(R.drawable.triangle), "Triangle")
                }
                Row {
                    VCard(painterResource(R.drawable.trapezoid),"Trapezoid")
                    VCard(painterResource(R.drawable.rectangle),"Rectangle")
                }

                Row {
                    VCard(painterResource(R.drawable.ellipse),"Ellipse")

                }

            }
        }

    }
}
