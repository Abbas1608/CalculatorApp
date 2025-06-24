package com.example.calculator.Screen.CGPA

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.calculator.R
import com.example.calculator.ResultCard.CgpaResult
import com.example.calculator.ui.theme.HCardBrush

//@Preview(showSystemUi = true)
@Composable
fun CgpaScreen(NavController: NavHostController)
{
    val Textinput1 = remember {
        mutableStateOf<String>("")
    }
    val Textinput2 = remember {
        mutableStateOf<String>("")
    }
    val Textinput3 = remember {
        mutableStateOf<String>("")
    }

    val Textinput4 = remember {
        mutableStateOf<String>("")
    }

    val Textinput5 = remember {
        mutableStateOf<String>("")
    }

    val Textinput6 = remember {
        mutableStateOf<String>("")
    }

    val Textinput7 = remember {
        mutableStateOf<String>("")
    }

    val Textinput8 = remember {
        mutableStateOf<String>("")
    }

    val ValidState1 = remember(Textinput1.value) {
        Textinput1.value.trim().isNotEmpty() &&
                Textinput1.value.trim().toFloatOrNull() != null
    }

    val ValidState2 = remember(Textinput2.value) {
        Textinput2.value.trim().isNotEmpty() &&
                Textinput2.value.trim().toFloatOrNull() != null
    }

    val ValidState3 = remember(Textinput3.value) {
        Textinput3.value.trim().isNotEmpty() &&
                Textinput3.value.trim().toFloatOrNull() != null
    }
    val ValidState4 = remember(Textinput4.value) {
        Textinput4.value.trim().isNotEmpty() &&
                Textinput4.value.trim().toFloatOrNull() != null
    }
    val ValidState5 = remember(Textinput5.value) {
        Textinput5.value.trim().isNotEmpty() &&
                Textinput5.value.trim().toFloatOrNull() != null
    }
    val ValidState6 = remember(Textinput6.value) {
        Textinput6.value.trim().isNotEmpty() &&
                Textinput6.value.trim().toFloatOrNull() != null
    }
    val ValidState7 = remember(Textinput7.value) {
        Textinput7.value.trim().isNotEmpty() &&
                Textinput7.value.trim().toFloatOrNull() != null
    }
    val ValidState8 = remember(Textinput8.value) {
        Textinput8.value.trim().isNotEmpty() &&
                Textinput8.value.trim().toFloatOrNull() != null
    }

    val showError = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val resultState = remember { mutableStateOf(0.0) }


    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        CgpaTopBar(NavController)
        Spacer(modifier = Modifier.height(20.dp))

        //1
        subjectText("Subject 1")
        textButton(
            valueState = Textinput1,
            labelId = "Subject Grade",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState1,
            onActions = KeyboardActions {
                if (!ValidState1) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )
        textButton(
            valueState = Textinput2,
            labelId = "Enter Credit",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState2,
            onActions = KeyboardActions {
                if (!ValidState2) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )

        //2
        subjectText("Subject 2")
        textButton(
            valueState = Textinput3,
            labelId = "Subject Grade",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState3,
            onActions = KeyboardActions {
                if (!ValidState3) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )
        textButton(
            valueState = Textinput4,
            labelId = "Enter Credit",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState4,
            onActions = KeyboardActions {
                if (!ValidState4) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )

        //3
        subjectText("Subject 3")
        textButton(
            valueState = Textinput5,
            labelId = "Subject Grade",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState5,
            onActions = KeyboardActions {
                if (!ValidState5) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )
        textButton(
            valueState = Textinput6,
            labelId = "Enter Credit",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState6,
            onActions = KeyboardActions {
                if (!ValidState6) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )

        //4
        subjectText("Subject 4")
        textButton(
            valueState = Textinput7,
            labelId = "Subject Grade",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState7,
            onActions = KeyboardActions {
                if (!ValidState7) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )
        textButton(
            valueState = Textinput8,
            labelId = "Enter Credit",
            enabled = true,
            isSingleLine = true,
            isError = showError.value && !ValidState8,
            onActions = KeyboardActions {
                if (!ValidState8) return@KeyboardActions
                keyboardController?.hide()
                showError.value = false
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column {
                FloatingActionButton(
                    onClick = {
                        if (ValidState1 && ValidState2 && ValidState3) {
                            val userInput1 = Textinput1.value.trim().toFloatOrNull()
                            val userInput2 = Textinput2.value.trim().toFloatOrNull()
                            val userInput3 = Textinput3.value.trim().toFloatOrNull()
                            val userInput4 = Textinput4.value.trim().toFloatOrNull()
                            val userInput5 = Textinput5.value.trim().toFloatOrNull()
                            val userInput6 = Textinput6.value.trim().toFloatOrNull()
                            val userInput7 = Textinput7.value.trim().toFloatOrNull()
                            val userInput8 = Textinput8.value.trim().toFloatOrNull()


                            if ((userInput1 != null && userInput1 > 0) &&
                                (userInput2 != null && userInput2 > 0) &&
                                (userInput3 != null && userInput3 > 0) &&
                                (userInput4 != null && userInput4 > 0)&&
                                (userInput5 != null && userInput5 > 0)&&
                                (userInput6 != null && userInput6 > 0)&&
                                (userInput7 != null && userInput7 > 0)&&
                                (userInput8 != null && userInput8 > 0)
                                ) {
                                val result = CgpaResult(userInput1, userInput2, userInput3,userInput4
                                ,userInput5,userInput5,userInput7,userInput8)
                                resultState.value = result
                                showError.value = false // Clear any previous errors
                                Log.d("resultcal", "Shape: , Inputs: $userInput1, $userInput2, $userInput3 ")
                            }
                        } else {
                            // Show error message when validation fails
                            showError.value = true
                            val missingFields = mutableListOf<String>("")

                            if (!ValidState1) missingFields.add("")
                            if (!ValidState2) missingFields.add("")
                            if (!ValidState3) missingFields.add("")

                            errorMessage.value = "Please enter valid values for: ${missingFields.joinToString(", ")}"
                        }
                    },
                    modifier = Modifier.size(width = 250.dp, height = 45.dp)
                    ,
                    containerColor = colorResource(R.color.Dark_Blue),
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(5.dp)
                ) {
                    Text(text = "Calculate CGPA")
                }
                Box(
                        modifier = Modifier.background(brush = HCardBrush)
                            .size(200.dp)
                        ) {

                }
            }
        }
    }
}




