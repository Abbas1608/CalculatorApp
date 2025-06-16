package com.example.calculator

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.Navigation.CalRoutes
import com.example.calculator.ui.theme.VCardBrush


@Composable
fun VCard(
    Image: Painter,
    Text: String,
    onClick :()-> Unit
) {
    val context = LocalContext.current

    Row {

        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(150.dp, height = 170.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(
                    brush = VCardBrush
                )
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = Image,
                    contentDescription = "Rubik Cube",
                    modifier = Modifier.size(96.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = Text,
                    fontSize = 20.sp,
                    color = Color(0xFF002244),
                    fontWeight = FontWeight.Bold
                )
            }
        }

//        Spacer(modifier = Modifier.width(10.dp))
//        Box(
//            modifier = Modifier
//                .padding(16.dp)
//                .size(150.dp, height = 170.dp)
//                .clip(RoundedCornerShape(24.dp))
//                .background(
//                    brush = VCardBrush
//                ),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_launcher_background),
//                    contentDescription = "Rubik Cube",
//                    modifier = Modifier.size(96.dp)
//                )
//                Spacer(modifier = Modifier.height(12.dp))
//                Text(
//                    text = "Area",
//                    fontSize = 20.sp,
//                    color = Color(0xFF002244),
//                    fontWeight = FontWeight.Bold
//                )
         //   }
        //}
    }

}
