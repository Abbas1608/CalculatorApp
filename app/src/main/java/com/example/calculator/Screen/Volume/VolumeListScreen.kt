package com.example.calculator.Screen.Volume

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.calculator.R
import com.example.calculator.VCard

@Composable
fun VolumeListScreen(NavController: NavHostController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        VolumeTopBar()

        LazyColumn {
            item {
                Row {
                    VCard(painterResource(R.drawable.cone), "Cone", onClick = {})
                    VCard(painterResource(R.drawable.cylinder), "Cylinder", onClick = {})
                }

                Row {
                    VCard(painterResource(R.drawable.cube), "Cube", onClick = {})
                    VCard(painterResource(R.drawable.cuboid), "Cuboid", onClick = {})
                }
                Row {
                    VCard(painterResource(R.drawable.sphere), "Sphere", onClick = {})
                    VCard(
                        painterResource(R.drawable.triangle_prism),
                        "Triangle Prism",
                        onClick = {}
                    )
                }


            }
        }

    }
}