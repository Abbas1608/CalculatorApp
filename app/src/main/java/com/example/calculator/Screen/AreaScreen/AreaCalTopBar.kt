package com.example.calculator.Screen.AreaScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.R
import com.example.calculator.ui.theme.HCardBrush

@Composable
fun AreaCalTopBAr(NavController: NavHostController)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(brush = HCardBrush),

        )
    {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 20.dp)
                .fillMaxSize()
        ) {

            Icon(painter = painterResource(R.drawable.outline_keyboard_double_arrow_left_24),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
                    .clickable(onClick = {
                        NavController.navigate(CalRoutes.AreaListScreen.name)
                    }),
                tint = colorResource(R.color.Dark_Blue))

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Area Calculator ",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = colorResource(R.color.Dark_Blue),

                )

        }


    }

}