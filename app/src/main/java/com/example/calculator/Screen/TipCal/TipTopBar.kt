package com.example.calculator.Screen.TipCal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.ui.theme.HCardBrush

@Preview
@Composable
fun TipTopBar()
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(brush = HCardBrush),

        )
    {

        Column {

            Text(text = "Tip Calculator",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = colorResource(R.color.Dark_Blue),
                modifier = Modifier.padding(start = 40.dp, top = 20.dp)
                    .align (alignment = Alignment.CenterHorizontally)
            )
//            HorizontalDivider(modifier = Modifier.width(120.dp)
//                .align(alignment = Alignment.CenterHorizontally)
//                .clip(RoundedCornerShape(2.dp)),
//                thickness = 3.dp,
//                color = colorResource(R.color.Dark_Blue))
        }
    }
}
