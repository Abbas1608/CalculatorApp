package com.example.calculator.Screen.AreaScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.VCard
import com.example.calculator.R


@Composable
fun AreaListScreen(NavController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AreaTopBar(NavController)

        LazyColumn {
            item {
                Row {
                    VCard(painterResource(R.drawable.cricle), Text = "Circle", onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Circle")
                    })
                    VCard(painterResource(R.drawable.rhombus), "Rhombus", onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Rhombus")
                    })
                }

                Row {
                    VCard(painterResource(R.drawable.square), "Square",onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Square")
                    } )
                    VCard(painterResource(R.drawable.triangle), "Triangle", onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Triangle")
                    })
                }
                Row {
                    VCard(painterResource(R.drawable.trapezoid), "Trapezoid", onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Trapezoid")
                    })
                    VCard(painterResource(R.drawable.rectangle), "Rectangle", onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Rectangle")
                    })
                }

                Row {
                    VCard(painterResource(R.drawable.ellipse), "Ellipse", onClick = {
                        NavController.navigate("${CalRoutes.AreaCalScreen.name}/Ellipse")
                    })

                }

            }
        }

    }
}
