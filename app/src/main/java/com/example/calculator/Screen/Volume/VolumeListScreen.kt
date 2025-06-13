package com.example.calculator.Screen.Volume

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.R
import com.example.calculator.Screen.AreaScreen.AreaTopBar
import com.example.calculator.VCard

@Preview(showSystemUi = true)
@Composable
fun VolumeListScreen()
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        VolumeTopBar()

        LazyColumn {
            item {
                Row {
                    VCard(painterResource(R.drawable.cone), "Cone")
                    VCard(painterResource(R.drawable.cylinder), "Cylinder")
                }

                Row {
                    VCard(painterResource(R.drawable.cube), "Cube")
                    VCard(painterResource(R.drawable.cuboid), "Cuboid")
                }
                Row {
                    VCard(painterResource(R.drawable.sphere),"Sphere")
                    VCard(painterResource(R.drawable.triangle_prism),"Triangle Prism")
                }


            }
        }

    }
}