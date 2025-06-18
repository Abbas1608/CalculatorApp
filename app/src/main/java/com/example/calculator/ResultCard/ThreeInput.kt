package com.example.calculator.ResultCard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R

@Composable
fun ThreeInput(
    Image: Painter,
    Text: String,
    formula : String,
    labelText1: String,
    labelText2: String,
    labelText3: String,
    onValChange:(String ) -> Unit= {}
){
    val TextState1 = remember {
        mutableStateOf("")
    }
    val TextState2 = remember {
        mutableStateOf("")
    }

    val TextState3 = remember {
        mutableStateOf("")
    }


    val ValidState1 = remember(TextState1.value) {
        TextState1.value.trim().isNotEmpty() &&
                TextState1.value.trim().toFloatOrNull() != null
    }

    val ValidState2 = remember(TextState2.value) {
        TextState2.value.trim().isNotEmpty() &&
                TextState2.value.trim().toFloatOrNull() != null
    }

    val ValidState3 = remember(TextState3.value) {
        TextState3.value.trim().isNotEmpty() &&
                TextState3.value.trim().toFloatOrNull() != null
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    val resultState = remember { mutableStateOf(0.0) }

    // Add error state for validation feedback
    val showError = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(top = 20.dp)
    )
    {
        Image(
            painter = Image,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Formula",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.Dark_Blue))

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = formula,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.Dark_Blue))
        Spacer(modifier = Modifier.height(20.dp))

        InputButton(
            valueState = TextState1,
            labelId = labelText1,
            isSingleLine = true,
            enabled = true,
            isError = showError.value && !ValidState1,
            onActions = KeyboardActions {
                if (!ValidState1) return@KeyboardActions
                onValChange(TextState1.value.trim())
                keyboardController?.hide()
                showError.value = false
            })

        Spacer(modifier = Modifier.height(20.dp))

        InputButton(
            valueState = TextState2,
            labelId = labelText2,
            isSingleLine = true,
            enabled = true,
            isError = showError.value && !ValidState2,
            onActions = KeyboardActions {
                if (!ValidState2) return@KeyboardActions
                onValChange(TextState2.value.trim())
                keyboardController?.hide()
                showError.value = false
            })

        Spacer(modifier = Modifier.height(20.dp))

        InputButton(
            valueState = TextState3,
            labelId = labelText3,
            isSingleLine = true,
            enabled = true,
            isError = showError.value && !ValidState3,
            onActions = KeyboardActions {
                if (!ValidState3) return@KeyboardActions
                onValChange(TextState3.value.trim())
                keyboardController?.hide()
                showError.value = false
            })

        Spacer(modifier = Modifier.height(20.dp))


        FloatingActionButton( onClick = {
            if (ValidState1 && ValidState2 && ValidState3) {
                val userInput1 = TextState1.value.trim().toFloatOrNull()
                val userInput2 = TextState2.value.trim().toFloatOrNull()
                val userInput3 = TextState3.value.trim().toFloatOrNull()

                if ((userInput1 != null && userInput1 > 0) &&
                    (userInput2 != null && userInput2 > 0) &&
                    (userInput3 != null && userInput3 > 0)) {
                    val result = resultcal3(Text, userInput1, userInput2, userInput3)
                    resultState.value = result
                    showError.value = false // Clear any previous errors
                    Log.d("resultcal", "Shape: $Text, Inputs: $userInput1, $userInput2, $userInput3, Result: $result")
                }
            } else {
                // Show error message when validation fails
                showError.value = true
                val missingFields = mutableListOf<String>()

                if (!ValidState1) missingFields.add(labelText1)
                if (!ValidState2) missingFields.add(labelText2)
                if (!ValidState3) missingFields.add(labelText3)

                errorMessage.value = "Please enter valid values for: ${missingFields.joinToString(", ")}"
            }
        },
            modifier = Modifier.size(width = 250.dp, height = 45.dp),
            containerColor = colorResource(R.color.Dark_Blue),
            contentColor = Color.White,
            elevation = FloatingActionButtonDefaults.elevation(5.dp)
        ) {
            Text(text = "Calculate $Text")
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Show error message if validation fails
        if (showError.value) {
            Text(
                text = errorMessage.value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Red,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        // Display result
        if (resultState.value > 0){
            Text(text = "Answer = ${String.format("%.2f", resultState.value)}",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.Dark_Blue))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Square Units",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.Dark_Blue))
        }
    }
}

fun resultcal3(typeofshape: String, value1: Float,value2: Float, value3: Float): Double {
    return when(typeofshape) {
        "Trapezoid" -> {
            ((0.5 * (value1+value2) * value3).toDouble())
        }
        "Cuboid" -> {
            (value1*value2*value3).toDouble()
        }
        else -> 0.0
    }
}