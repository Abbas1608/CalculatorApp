package com.example.calculator.Screen.CalulatorScreen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.Harder.TopBarHarder
import com.example.calculator.R
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.livedata.observeAsState
import com.example.calculator.ui.theme.HCardBrush


@Composable
fun NormalCalculatorScreen(calviewmodle: CalculatorViewMode)
{
    Column {
        TopBarHarder()
        Calculator(calviewmodle)
    }
}

@Composable
fun Calculator(viewMode: CalculatorViewMode) {
    val equationText = viewMode.equationText.observeAsState()
    val resultText = viewMode.resultText.observeAsState()

    val elementList = listOf<String>(
        "AC", "⌫", "%", "/",
        "7", "8", "9", "X",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        ".", "0", "="

//        "AC", "⌫", "(", ")",
//        "7", "8", "9", "X",
//        "4", "5", "6", "-",
//        "1", "2", "3", "+",
//        ".", "0", "%","/"
    )
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text =equationText.value?:"",
                fontSize = 30.sp,
                style = TextStyle(
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(end = 10.dp, start = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = resultText.value?:"0",
                fontSize = 60.sp,
                style = TextStyle(
                    textAlign = TextAlign.End,
                    color = colorResource(R.color.Dark_Blue)
                ),
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(end = 10.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(bottom = 1.dp)
            ) {
                // Add all items except the equal button
                items(elementList.filter { it != "=" }) { symbol ->
                    CalculatorButton(symbol, onClick = {
                        viewMode.onButtonClick(symbol)
                    })
                }

//                // Add the equal button with span of 2
                item(span = { GridItemSpan(2) }) {
                    CalculatorButton("=",{
                        viewMode.onButtonClick("=")
                    })
                }
            }
        }
    }


@Composable
fun CalculatorButton(symbol: String, onClick :()-> Unit) {
    val modifier = Modifier
        .aspectRatio(if (symbol == "=") 2f else 1f)
        .fillMaxWidth()
        .border(
            1.dp, Color.Black,
        )

    when (symbol) {
        "AC" -> {
            FloatingActionButton(
                onClick = onClick,
                containerColor = Color.White,
                contentColor = Color.Red,
                modifier = modifier,
            ) {
                Text(
                    symbol,
                    color = Color.Red,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        "⌫" -> {
            FloatingActionButton (
                onClick = onClick,
                containerColor = Color.White,
                contentColor = colorResource(R.color.Blue),
                modifier = modifier
            ) {
                Text(symbol, color = colorResource(R.color.Light_blue), fontSize = 28.sp
                , fontWeight = FontWeight.Bold)
            }
        }

        "%", "/", "X","(",")"-> {
            FloatingActionButton (
                onClick = onClick,
                containerColor = Color.White,
                contentColor = colorResource(R.color.Blue),
                modifier = modifier
            ) {
                Text(
                    symbol, color = colorResource(R.color.Light_blue),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        "-"->{
            FloatingActionButton (
                onClick = onClick,
                containerColor = Color.White,
                contentColor = colorResource(R.color.Blue),
                modifier = modifier
            ) {
                Text(
                    symbol, color = colorResource(R.color.Light_blue),
                    fontSize = 60.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        "+"->{
            FloatingActionButton (
                onClick = onClick,
                containerColor = Color.White,
                contentColor = colorResource(R.color.Blue),
                modifier = modifier
            ) {
                Text(
                    symbol, color = colorResource(R.color.Light_blue),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        "=" -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier.background(
                    brush = HCardBrush
                )
                    .clickable(onClick = onClick)
            ) {
                Text(
                    symbol, fontSize = 50.sp, fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.Dark_Blue)
                )
            }
        }

        else -> {
            FloatingActionButton (
                onClick = onClick,
                containerColor = Color.White,
                contentColor = colorResource(R.color.Blue),
                modifier = modifier
            ) {
                Text(
                    symbol, fontSize = 28.sp,
                    color = Color.Black
                )
            }
        }
    }
}



