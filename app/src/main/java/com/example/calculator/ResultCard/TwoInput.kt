package com.example.calculator.ResultCard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R


@Composable
fun TwoInput(
    Image: Painter,
    Text: String,
    Typetext: String,
    formula : String,
    labelText1: String,
    labelText2: String,
    onValChange:(String ) -> Unit= {}
){
    val TextState1 = remember {
        mutableStateOf("")
    }
    val TextState2 = remember {
        mutableStateOf("")
    }

    // FIXED: Added null safety and proper validation
    val ValidState1 = remember(TextState1.value) {
        TextState1.value.trim().isNotEmpty() &&
                TextState1.value.trim().toFloatOrNull() != null // Check if it's a valid number
    }

    val ValidState2 = remember(TextState2.value) {
        TextState2.value.trim().isNotEmpty() &&
                TextState2.value.trim().toFloatOrNull() != null // Check if it's a valid number
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    val resultState = remember { mutableStateOf(0.0) }
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
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Formula:",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.Dark_Blue))

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = Typetext ,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.Dark_Blue))

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "= $formula",
            fontSize = 22.sp,
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

        // FIXED: Added null safety and moved calculation inside the button click
        FloatingActionButton( onClick = {
            if (ValidState1) {
                // Convert to Float safely
                val userInput1 = TextState1.value.trim().toFloatOrNull()
                val userInput2 = TextState2.value.trim().toFloatOrNull()

                if ( (userInput1 != null && userInput1 > 0) && (userInput2 != null && userInput2 > 0)) { // Added positive number check
                    val result = resultcal2(Text, userInput1,userInput2)
                    resultState.value = result
                    showError.value = false
                    Log.d("resultcal", "Shape: $Text, Input: $userInput1, Result: $result")
                }
                else {
                    // Show error message when validation fails
                    showError.value = true
                    val missingFields = mutableListOf<String>()

                    if (!ValidState1) missingFields.add(labelText1)
                    if (!ValidState2) missingFields.add(labelText2)

                    errorMessage.value = "Please enter valid values for: ${missingFields.joinToString(", ")}"
                }

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

fun resultcal2(typeofshape: String, value1: Float,value2: Float): Double {
    return when(typeofshape) {
        "Triangle" ,"Triangle_Prism" ,"Rectangle" -> {
            (value1 * value2).toDouble()
        }
        "Cone" ->{
            (0.33 * Math.PI * (value1*value1) *value2).toDouble()
        }
        "Cylinder" ->{
            (Math.PI * (value1*value1) * value2)
        }
        "Ellipse"->{
            (Math.PI * value1 * value2)
        }
        "Rhombus" -> {
            (0.5 * value1 * value2)
        }

        else -> 0.0
    }
}