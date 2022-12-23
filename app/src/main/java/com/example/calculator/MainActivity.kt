package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set position of EditText cursor to the end.
        val editText = findViewById<EditText>(R.id.editTextValue)
        editText.setSelection(editText.length())
    }

    fun onButtonPressed(view:View)
    {
        val selectedButton = view as Button
        val editText = findViewById<EditText>(R.id.editTextValue)

        if (newOperator)
        {
            findViewById<EditText>(R.id.editTextValue).setText("")
        }

        newOperator = false

        var selectedButtonValue : String = editText.text.toString()

        when(selectedButton.id)
        {
           getButtonId(R.id.btn0)->
           {
                selectedButtonValue+="0"
           }
             getButtonId(R.id.btn1)->
            {
                  selectedButtonValue+="1"
            }
            getButtonId(R.id.btn2)->
            {
                selectedButtonValue+="2"
            }
            getButtonId(R.id.btn3)->
            {
                selectedButtonValue+="3"
            }
            getButtonId(R.id.btn4)->
            {
                selectedButtonValue+="4"
            }
            getButtonId(R.id.btn5)->
            {
                selectedButtonValue+="5"
            }
            getButtonId(R.id.btn6)->
            {
                selectedButtonValue+="6"
            }
            getButtonId(R.id.btn7)->
            {
                selectedButtonValue+="7"
            }
            getButtonId(R.id.btn8)->
            {
                selectedButtonValue+="8"
            }
            getButtonId(R.id.btn9)->
            {
                selectedButtonValue+="9"
            }
            getButtonId(R.id.btnIncreaseDecrease)->
            {
                selectedButtonValue="-" + selectedButtonValue
            }
            getButtonId(R.id.btnClear)->
            {
                selectedButtonValue = ""
            }
        }

        editText.setText(selectedButtonValue)
    }

     private fun getButtonId(id: Int): Int {
        return findViewById<Button>(id).id
    }

    var operator : String = "*"
    var oldNumber: String = ""
    var newOperator: Boolean = true

    fun onOperation(view:View)
    {
        val selectedButton = view as Button
        val editText = findViewById<EditText>(R.id.editTextValue)
        var selectedButtonValue : String = editText.text.toString()

        when(selectedButton.id)
        {
            getButtonId(R.id.btnDivide)->
            {
                operator = "/"
            }
            getButtonId(R.id.btnMultiply)->
            {
                operator = "x"
            }
            getButtonId(R.id.btnSubtract)->
            {
                operator = "-"
            }
            getButtonId(R.id.btnAdd)->
            {
                operator = "+"
            }
        }
        oldNumber = editText.text.toString()
        newOperator = true
    }

    fun onEqual(view:View)
    {
        var editText = findViewById<EditText>(R.id.editTextValue)
        var newNumber : String = editText.text.toString()
        var resultNumber : Double? = null

        when(operator)
        {
            "/"->
            {
                resultNumber = oldNumber.toDouble()/newNumber.toDouble()
            }
            "x"->
            {
                resultNumber = oldNumber.toDouble()*newNumber.toDouble()
            }
            "-"->
            {
                resultNumber = oldNumber.toDouble()-newNumber.toDouble()
            }
            "+"->
            {
                resultNumber = oldNumber.toDouble()+newNumber.toDouble()
            }
        }

        editText.setText(resultNumber.toString())
        newOperator = true

    }

}