package com.example.calculator.Screen.CalulatorScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewMode : ViewModel() {

    private val _equationtext = MutableLiveData("")
    val equationText : LiveData<String> = _equationtext

    private val _resulttext = MutableLiveData("0")
    val resultText : LiveData<String> = _resulttext


    fun onButtonClick(btn :String){
        Log.d("click but",btn)

        _equationtext.value?.let {
            if (btn== "AC"){
                _equationtext.value = ""
                _resulttext.value = "0"
                return
            }
            if (btn== "⌫"){
                if (it.isNotEmpty())
                { _equationtext.value = it.substring(0,it.length-1)}
                return
            }
            if (btn == "=")
            {
               _equationtext.value = _resulttext.value
                return

            }

            _equationtext.value = it + btn

            // result calculate
            try {

                    _resulttext.value = calculation(_equationtext.value.toString())

            }
            catch (_ : Exception){}
        }

    }

    fun calculation(equation : String): String
    {
        val context : Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable : Scriptable = context.initStandardObjects()
        var finalResult = context.evaluateString(scriptable,equation,"Javascript",1,null).toString()
        if(finalResult.endsWith(".0")){
            finalResult = finalResult.replace(".0","")
        }
        return finalResult

    }
}