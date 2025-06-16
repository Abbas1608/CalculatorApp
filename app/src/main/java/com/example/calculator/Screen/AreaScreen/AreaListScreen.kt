package com.example.calculator.Screen.AreaScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.calculator.VCard
import com.example.calculator.R


@Composable
fun AreaListScreen(NavController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AreaTopBar()

        LazyColumn {
            item {
                Row {
                    VCard(painterResource(R.drawable.cricle), "Circle", onClick = {

                    })
                    VCard(painterResource(R.drawable.rhombus), "Rhombus", onClick = {})
                }

                Row {
                    VCard(painterResource(R.drawable.square), "Square",onClick = {} )
                    VCard(painterResource(R.drawable.triangle), "Triangle", onClick = {})
                }
                Row {
                    VCard(painterResource(R.drawable.trapezoid), "Trapezoid", onClick = {})
                    VCard(painterResource(R.drawable.rectangle), "Rectangle", onClick = {})
                }

                Row {
                    VCard(painterResource(R.drawable.ellipse), "Ellipse", onClick = {})

                }

            }
        }

    }
}
