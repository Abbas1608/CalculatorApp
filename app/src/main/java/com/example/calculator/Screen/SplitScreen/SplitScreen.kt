package com.example.calculator.Screen.SplitScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.R

@Composable
fun SplitScreen(NavController: NavHostController) {


    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)  // 2 seconds delay
        NavController.navigate(CalRoutes.NormalCalculatorScreen.name){
            popUpTo(0)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo2),
            contentDescription = null,
            Modifier.size(120.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Calcify",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = colorResource(R.color.Dark_Blue)
        )
        HorizontalDivider(
            modifier = Modifier.width(90.dp),
            color = colorResource(R.color.Dark_Blue)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Developed By Abbas Shaikh",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.Dark_Blue),

            )

    }
}

