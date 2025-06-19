package com.example.calculator.Screen.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.VCard
import com.example.calculator.R

@Composable
// more(home screen )
fun HomeScreen(NavController: NavHostController)
{

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        HomeTopBar(NavController)

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            VCard(painterResource(R.drawable.area),"Area", onClick = {
                NavController.navigate(route = CalRoutes.AreaListScreen.name)
            })


            Spacer(modifier = Modifier.width(10.dp))

            VCard(painterResource(R.drawable.volume_icon),"Volume",onClick = {
                NavController.navigate(route = CalRoutes.VolumeListScreen.name)
            })
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            VCard(painterResource(R.drawable.formula_icon),"Formula", onClick = {
                NavController.navigate(route = CalRoutes.FormulaListScreen.name)
            })


            Spacer(modifier = Modifier.width(10.dp))

            VCard(painterResource(R.drawable.tip_icon),"Tip Calculator",onClick = {
                NavController.navigate(route = CalRoutes.TipCalculator.name)
            })
        }

    }


}