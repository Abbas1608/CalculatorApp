package com.example.calculator.Screen.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.R
import com.example.calculator.ui.theme.HCardBrush


@Composable
fun HomeTopBar(NavController: NavHostController)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(brush = HCardBrush),

        )
    {

        Row{

            Text(text = "Calculator",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = colorResource(R.color.Dark_Blue),
                modifier = Modifier.padding(start = 40.dp, top = 20.dp)
                    .align (alignment = Alignment.CenterVertically)
                    .clickable{NavController.navigate(route = CalRoutes.NormalCalculatorScreen.name)}
            )

            Spacer(modifier = Modifier.weight(1f))

            Column{
//                HorizontalDivider(modifier = Modifier.width(50.dp)
//                    .padding(start = 6.dp)
//                    .clip(RoundedCornerShape(2.dp)),
//                    thickness = 3.dp,
//                    color = colorResource(R.color.Dark_Blue))

                Text(text = "More",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = colorResource(R.color.Dark_Blue),
                    modifier = Modifier.padding(end = 40.dp, top = 20.dp)
                        .align (alignment = Alignment.CenterHorizontally)
                )
                HorizontalDivider(modifier = Modifier.width(50.dp)
                    .padding(start = 6.dp)
                    .clip(RoundedCornerShape(2.dp)),
                    thickness = 3.dp,
                    color = colorResource(R.color.Dark_Blue))

            }


        }


    }

}