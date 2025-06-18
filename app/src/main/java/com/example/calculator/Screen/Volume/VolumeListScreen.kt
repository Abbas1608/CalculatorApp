package com.example.calculator.Screen.Volume

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.R
import com.example.calculator.VCard

@Composable
fun VolumeListScreen(NavController: NavHostController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        VolumeTopBar(NavController)

        LazyColumn {
            item {
                Row {
                    VCard(painterResource(R.drawable.cone), "Cone", onClick = {
                        NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Cone")
                    })
                    VCard(painterResource(R.drawable.cylinder), "Cylinder", onClick = {
                        NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Cylinder")
                    })
                }

                Row {
                    VCard(painterResource(R.drawable.cube), "Cube", onClick = {
                        NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Cube")
                    })
                    VCard(painterResource(R.drawable.cuboid), "Cuboid", onClick = {
                        NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Cuboid")
                    })
                }
                Row {
                    VCard(painterResource(R.drawable.sphere), "Sphere", onClick = {
                        NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Sphere")
                    })
                    VCard(
                        painterResource(R.drawable.triangle_prism),"Triangle Prism",
                        onClick = {
                            NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Triangle_Prism")
                        })
                }

                VCard(
                    painterResource(R.drawable.triangle_prism),"Tetrahedron",
                    onClick = {
                        NavController.navigate("${CalRoutes.VolumeCalScreen.name}/Tetrahedron")
                    })


            }
        }

    }
}