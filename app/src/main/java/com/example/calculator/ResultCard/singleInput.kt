package com.example.calculator.ResultCard

import android.text.InputFilter
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
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.util.VelocityTrackerAddPointsFix
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.Screen.TipCal.InputField


@Composable
fun InputButton(
    modifier: Modifier = Modifier,
    valueState : MutableState<String>,
    labelId : String,
    enabled : Boolean,
    isSingleLine : Boolean,
    isError: Boolean = false,
    KeyBoardType : KeyboardType = KeyboardType.Number,
    imwAction: ImeAction = ImeAction.Next, // using next icon in keyboard
    onActions: KeyboardActions = KeyboardActions.Default
)
{
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it},
        label = { Text(text = labelId) },
        leadingIcon = { Icon(imageVector = Icons.Rounded.Calculate,
            contentDescription = " icon") },
        singleLine = isSingleLine,
        modifier = Modifier.padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
            .fillMaxWidth(),
        textStyle = TextStyle(fontSize = 18.sp,
            color = colorResource(R.color.Dark_Blue)),
        enabled = enabled,
        isError = isError,
        keyboardOptions = KeyboardOptions(keyboardType = KeyBoardType,
            imeAction = imwAction),
        keyboardActions = onActions
    )

}

@Composable
fun singleInput(Image: Painter,
                Text: String,
                formula : String,
                labelText: String,
                onValChange:(String ) -> Unit= {}){

    val TextState = remember {
        mutableStateOf("")
    }


    val ValidState = remember(TextState.value) {
        TextState.value.trim().isNotEmpty() &&
                TextState.value.trim().toFloatOrNull() != null
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
            valueState = TextState,
            labelId = labelText,
            isSingleLine = true,
            enabled = true,
            isError = showError.value && !ValidState,
            onActions = KeyboardActions {
                if (!ValidState) return@KeyboardActions
                onValChange(TextState.value.trim())
                keyboardController?.hide()
                showError.value = false
            })

        Spacer(modifier = Modifier.height(20.dp))


        FloatingActionButton( onClick = {
            if (ValidState) {
                // Convert to Float safely
                val userInput = TextState.value.trim().toFloatOrNull()
                if (userInput != null && userInput > 0) {
                    val result = resultcal(Text, userInput)
                    resultState.value = result
                    showError.value = false
                    Log.d("resultcal", "Shape: $Text, Input: $userInput, Result: $result")
                }
                else {
                    // Show error message when validation fails
                    showError.value = true
                    val missingFields = mutableListOf<String>()

                     missingFields.add(labelText)

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

// IMPROVED CALCULATION FUNCTION:
fun resultcal(typeofshape: String, value: Float): Double {
    return when(typeofshape) {
        "Circle" -> {
            Math.PI * value * value
        }
        "Square" -> {
            (value * value).toDouble()
        }
        "Cube" ->{
            (value*value*value).toDouble()
        }
        "Sphere" ->{
            (1.33 * Math.PI * (value*value*value))
        }
        "Tetrahedron" -> {
            ( (value* value*value) / 8.485 )
        }
        else -> 0.0
    }
}