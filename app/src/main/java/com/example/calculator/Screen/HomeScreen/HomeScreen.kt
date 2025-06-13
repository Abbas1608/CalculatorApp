package com.example.calculator.Screen.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.Harder.TopBarHarder
import com.example.calculator.VCard
import com.example.calculator.R

@Preview(showSystemUi = true)
@Composable
// more(home screen )
fun HomeScreen()
{

    Column {
        HomeTopBar()

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            VCard(painterResource(R.drawable.logo),"Area",)

            Spacer(modifier = Modifier.width(10.dp))

            VCard(painterResource(R.drawable.logo),"Area",)
        }

        Spacer(modifier = Modifier.height(20.dp))

        VCard(painterResource(R.drawable.logo),"Space",)

    }


}