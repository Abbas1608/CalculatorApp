package com.example.calculator.ResultCard

import android.text.InputFilter
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

    // checkiing is emtpy a not and trim the space around amount
    val ValidState = remember(TextState.value) {
        TextState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(top = 20.dp
            )
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


        var InputText= InputButton(
            valueState = TextState,
            labelId = labelText,
            isSingleLine = true,
            enabled = true,
            onActions = KeyboardActions {
                if (!ValidState) return@KeyboardActions
                // on validState : use to get value that user enter in app in our logcat(upper calling )
                onValChange(TextState.value.trim())
                keyboardController?.hide()
            })

//        var Result = 0.0
//        when(Text){
//            "Cricle" -> {Result = 3.14 * InputText. }
//
//        }


        Spacer(modifier = Modifier.height(20.dp))

        FloatingActionButton( onClick = {},
            modifier = Modifier.size(width = 250.dp, height = 45.dp),
            containerColor = colorResource(R.color.Dark_Blue),
            contentColor = Color.White,
            elevation = FloatingActionButtonDefaults.elevation(5.dp)
        ) {
            Text(text = "Calculate $Text")
        }


        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Answer =  345.9",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.Dark_Blue))
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = "Unit.",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.Dark_Blue))

    }
}