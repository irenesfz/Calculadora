package com.prueba.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.*
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        button_bracket_left.setOnClickListener {
            input.text = addToInputText(buttonValue = "(")
            output.text = ""
        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(buttonValue = ")")
            output.text = ""
        }
        button_0.setOnClickListener {
            input.text = addToInputText(buttonValue = "0")
            output.text = ""
        }

        button_1.setOnClickListener {
            input.text = addToInputText(buttonValue = "1")
            output.text = ""
        }
        button_2.setOnClickListener {
            input.text = addToInputText(buttonValue = "2")
            output.text = ""
        }
        button_3.setOnClickListener {
            input.text = addToInputText(buttonValue = "3")
            output.text = ""
        }
        button_4.setOnClickListener {
            input.text = addToInputText(buttonValue = "4")
            output.text = ""
        }
        button_5.setOnClickListener {
            input.text = addToInputText(buttonValue = "5")
            output.text = ""
        }
        button_6.setOnClickListener {
            input.text = addToInputText(buttonValue = "6")
            output.text = ""
        }
        button_7.setOnClickListener {
            input.text = addToInputText(buttonValue = "7")
            output.text = ""
        }
        button_8.setOnClickListener {
            input.text = addToInputText(buttonValue = "8")
            output.text = ""
        }
        button_9.setOnClickListener {
            input.text = addToInputText(buttonValue = "9")
            output.text = ""
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(buttonValue = ",")
            output.text = ""
        }
        button_division.setOnClickListener {
            input.text = addToInputText(buttonValue = "÷")
            output.text = ""
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText(buttonValue = "×")
            output.text = ""
        }
        button_addition.setOnClickListener {
            input.text = addToInputText(buttonValue = "+")
            output.text = ""
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText(buttonValue = "-")
            output.text = ""
        }
        button_equals.setOnClickListener {
            showResult()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //show error message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                //show result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            //show error message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}
