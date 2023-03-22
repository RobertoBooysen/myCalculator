package com.example.mycalculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaring variables(The IIE,2023)
        var editTextNumberOne=findViewById<EditText>(R.id.editTextNumberOne)
        var editTextNumberTwo=findViewById<EditText>(R.id.editTextNumberTwo)
        var textViewDisplay=findViewById<TextView>(R.id.textViewDisplay)
        var textViewErrorDisplay=findViewById<TextView>(R.id.textViewErrorDisplay)

        //Declaring buttons(The IIE,2023)
        val btnPlus=findViewById<Button>(R.id.btnPlus)
        val btnMinus=findViewById<Button>(R.id.btnMinus)
        val btnMultiply=findViewById<Button>(R.id.btnMultiply)
        val btnDivide=findViewById<Button>(R.id.btnDivide)
        val btnPower=findViewById<Button>(R.id.btnPower)
        val btnSquareRoot=findViewById<Button>(R.id.btnSquareRoot)
        val btnStatisticFunctions=findViewById<Button>(R.id.btnStatisticFunctions)

        //Plus button(The IIE,2023)
        btnPlus?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Plus button clicked", Toast.LENGTH_LONG).show()

            if(editTextNumberOne.text.toString()=="" || editTextNumberTwo.text.toString()=="" ){//TextBox validation
                textViewErrorDisplay.text="Input values in both fields!"
                textViewErrorDisplay.setTextColor(Color.parseColor("red"))
            }
            else{
                textViewErrorDisplay.text=""//Resetting error message
                var number1=editTextNumberOne.text.toString().toInt()
                var number2=editTextNumberTwo.text.toString().toInt()

                var totalPlus: Number=0
                totalPlus=number1+number2

                textViewDisplay.text ="Addition:  ${editTextNumberOne.text} + ${editTextNumberTwo.text} = $totalPlus "
            }
        }
        //Minus button(The IIE,2023)
        btnMinus?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Minus button clicked", Toast.LENGTH_LONG).show()

            if(editTextNumberOne.text.toString()=="" || editTextNumberTwo.text.toString()=="" ){//TextBox validation
                textViewErrorDisplay.text="Input values in both fields!"
                textViewErrorDisplay.setTextColor(Color.parseColor("red"))
            }
            else {
                textViewErrorDisplay.text = ""//Resetting error message
                var number1=editTextNumberOne.text.toString().toInt()
                var number2=editTextNumberTwo.text.toString().toInt()

                var totalMinus: Number=0
                totalMinus=number1-number2

                textViewDisplay.text ="Subtraction:  ${editTextNumberOne.text} - ${editTextNumberTwo.text} = $totalMinus "
            }
        }
        //Multiply button(The IIE,2023)
        btnMultiply?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Multiply button clicked", Toast.LENGTH_LONG).show()

            if(editTextNumberOne.text.toString()=="" || editTextNumberTwo.text.toString()=="" ){//TextBox validation
                textViewErrorDisplay.text="Input values in both fields!"
                textViewErrorDisplay.setTextColor(Color.parseColor("red"))
            }
            else {
                textViewErrorDisplay.text = ""//Resetting error message
                var number1=editTextNumberOne.text.toString().toInt()
                var number2=editTextNumberTwo.text.toString().toInt()

                var totalMultiply: Number=0
                totalMultiply=number1*number2

                textViewDisplay.text ="Multiplication:  ${editTextNumberOne.text} * ${editTextNumberTwo.text} = $totalMultiply "
            }
        }
        //Division button(The IIE,2023)
        btnDivide?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Divide button clicked", Toast.LENGTH_LONG).show()

            if(editTextNumberOne.text.toString()=="" || editTextNumberTwo.text.toString()=="" ){//TextBox validation
                textViewErrorDisplay.text="Input values in both fields!"
                textViewErrorDisplay.setTextColor(Color.parseColor("red"))
            }
            else {
                textViewErrorDisplay.text = ""//Resetting error message
                var number1=editTextNumberOne.text.toString().toInt()
                var number2=editTextNumberTwo.text.toString().toInt()

                var totalDivide: Number=0
                //If-else statement so user can't divide by 0
                if(number2==0){
                    textViewDisplay.text ="Can't divide by 0 !"
                }
                else{
                    totalDivide=number1/number2
                    textViewDisplay.text ="Division:  ${editTextNumberOne.text} / ${editTextNumberTwo.text} = $totalDivide "
                }
            }
        }
        //Power button(The IIE,2023)
        btnPower?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Power button clicked", Toast.LENGTH_LONG).show()

            if(editTextNumberOne.text.toString()=="" || editTextNumberTwo.text.toString()=="" ){//TextBox validation
                textViewErrorDisplay.text="Input values in both fields!"
                textViewErrorDisplay.setTextColor(Color.parseColor("red"))
            }
            else {
                textViewErrorDisplay.text = ""//Resetting error message
                var number1=editTextNumberOne.text.toString().toInt()
                var number2=editTextNumberTwo.text.toString().toInt()

                var totalPower: Number=0
                totalPower= number1.toDouble().pow(number2.toDouble())

                textViewDisplay.text ="Power: ${editTextNumberOne.text} to the power of ${editTextNumberTwo.text}= $totalPower "
            }
        }
        //Square root button(The IIE,2023)
        btnSquareRoot?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Square root button clicked", Toast.LENGTH_LONG).show()

            if(editTextNumberOne.text.toString()=="" ){//TextBox validation
                textViewErrorDisplay.text="Input a value in the first field!"
                textViewErrorDisplay.setTextColor(Color.parseColor("red"))
            }
            else {
                textViewErrorDisplay.text=""//Resetting error message
                var number1=editTextNumberOne.text.toString().toDouble()
                var totalSquareRoot: Number=0
                totalSquareRoot= sqrt(number1)

                textViewDisplay.text ="Square root: √${editTextNumberOne.text} = $totalSquareRoot "
            }
        }
        //Statistic functions button(The IIE,2023)
        btnStatisticFunctions?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Statistic functions button clicked", Toast.LENGTH_LONG).show()

            //Redirect to statistic functions page(Schwarz, 2021)
            val intent= Intent(this,StatisticFunctions::class.java)

            startActivity(intent);
        }
    }
}
//References List:
//Techie Delight .2016. Declare and initialize an array in Kotlin. [Online].Available at: https://www.techiedelight.com/declare-initialize-array-kotlin/ [Accessed: 22 March 2023].
//Techie Delight .2016. Find minimum and maximum elements in an array in Kotlin, Techie Delights. [Online].Available at: https://www.techiedelight.com/find-minimum-maximum-element-array-kotlin/ [Accessed: 22 March 2023].
//Techie Delight .2017. Find average of all items in a List in Kotlin, Techie Delights. [Online].Available at: https://www.techiedelight.com/find-average-of-all-items-in-a-list-in-kotlin/ [Accessed: 22 March 2023].
//The IIE.2023. OPEN SOURCE CODING (INTRODUCTION)[OPSC6311 Module Manual].The Independent Institute of Education: Unpublished.
//Schwarz, S. 2021. How to open a new activity with a button click -Android Kotlin Example, Medium. [Online]. Available at: https://medium.com/@simple.schwarz/how-to-open-a-new-activity-with-a-button-click-android-kotlin-example-bd2107946bbe [Accessed: 21 March 2023].