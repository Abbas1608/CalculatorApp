package com.example.calculator.Screen.TipCal

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculator.R

@Composable
fun TopHarder(TotalPrePerson : Double )
{
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(20.dp)
        .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        color = colorResource(R.color.white)
    ){
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            // variable for double value as 123.00(2 decimal )
            val Total = "%.2f".format(TotalPrePerson)

            Text(text = "Total Pre Person",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
//              style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.Dark_Blue))

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "$$Total",
                fontWeight = FontWeight.ExtraBold,
//              fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(R.color.purple_500))
        }
    }
}


@Composable
fun TipMainContent(NavController: NavHostController) {
    Column {
        TipTopBar(NavController)

        BillFrom() { billAmt ->
            Log.d("AMT", "MainContent $billAmt") // tag : logcat name that value is store enter by user

        }
    }

}


// function for handling values and ui

@Composable
fun BillFrom(modifier: Modifier = Modifier,
             onValChange:(String ) -> Unit= {}) {
    val TotalBillState = remember {
        mutableStateOf("")
    }

    // checkiing is emtpy a not and trim the space around amount
    val ValidState = remember(TotalBillState.value) {
        TotalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Slider variable
    val sliderPositionState = remember {
        mutableStateOf(0f)// float value
    }

    // Tip Percentage
    val tipPercentage = (sliderPositionState.value * 100).toInt()

    // Split state for icon inc and desc
    val splitByState = remember {
        mutableStateOf(1)
    }
    val RangeSplit = IntRange(start = 1, endInclusive = 20)

    val tipAmountState = remember {
        mutableDoubleStateOf(0.0) // double value
    }

    val totalPerPersonState = remember {
        mutableDoubleStateOf(0.0)
    }


    Column {

        Spacer(modifier = Modifier.height(40.dp))

        TopHarder(totalPerPersonState.value)

        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 1.dp, color = colorResource(R.color.Light_Grey)),
            color = MaterialTheme.colorScheme.background
        )
        {


            Column(
                modifier = Modifier.padding(6.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            )
            {
                InputField(
                    valueState = TotalBillState,
                    labelId = "Enter Bill",
                    isSingleLine = true,
                    enabled = true,
                    onActions = KeyboardActions {
                        if (!ValidState) return@KeyboardActions
                        // on validState : use to get value that user enter in app in our logcat(upper calling )
                        onValChange(TotalBillState.value.trim())
                        keyboardController?.hide()
                    })

                if (ValidState) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {

                        Text(
                            text = "Split",
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(start = 13.dp),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Row(
                            modifier = Modifier.padding(3.dp),
                            horizontalArrangement = Arrangement.End
                        ) {

                            RoundIconButton(
                                imageVector = Icons.Default.Remove,
                                onClick = {
                                    splitByState.value =
                                        if (splitByState.value > 1) splitByState.value - 1
                                        else 1
                                    totalPerPersonState.value =
                                        calculateTotalPerPerson(
                                            totalBill = TotalBillState.value.toDouble(),
                                            SplitBy = splitByState.value,
                                            tipPercentage
                                        )
                                }

                            )

                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                text = "${splitByState.value}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterVertically)
                                    .padding(start = 9.dp, end = 9.dp)
                            )

                            Spacer(modifier = Modifier.width(3.dp))

                            RoundIconButton(
                                imageVector = Icons.Default.Add,
                                onClick = {
                                    splitByState.value =
                                        if (splitByState.value < RangeSplit.last) {
                                            splitByState.value + 1
                                        } else {
                                            1
                                        }
                                    totalPerPersonState.value =
                                        calculateTotalPerPerson(
                                            totalBill = TotalBillState.value.toDouble(),
                                            SplitBy = splitByState.value,
                                            tipPercentage
                                        )
                                })
                        }

                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    // tip row
                    Row {

                        Text(
                            text = "Tip ",
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(start = 13.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )


                        Spacer(modifier = Modifier.width(250.dp))

                        Text(
                            text = "$ ${tipAmountState.value}",
                            modifier = Modifier.align(alignment = Alignment.CenterVertically),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    HorizontalDivider(
                        thickness = 0.5.dp,
                        modifier = Modifier
                            .width(100.dp)
                            .align(alignment = Alignment.End)
                            .padding(top = 5.dp, end = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        Text(
                            text = "$tipPercentage%",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        // Slider
                        Slider(
                            value = sliderPositionState.value,
                            onValueChange = { newVal ->
                                sliderPositionState.value = newVal // this physical change line
                                tipAmountState.value =
                                    CalculateTotalTip(
                                        TotalBillState.value.toDouble(),
                                        tipPercentage
                                    )
                                totalPerPersonState.value =
                                    calculateTotalPerPerson(
                                        totalBill = TotalBillState.value.toDouble(),
                                        SplitBy = splitByState.value,
                                        tipPercentage
                                    )
                            },
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 5.dp
                            ),
                            steps = 5,
                            valueRange = 0f..1f
                        )

                    }
                } else {
                    Box { }
                }


            }
        }

    }
}

