package com.example.mycalculator

import android.content.Intent
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

        //Declaring variables
        var editTextNumberOne=findViewById<EditText>(R.id.editTextNumberOne)
        var editTextNumberTwo=findViewById<EditText>(R.id.editTextNumberTwo)
        var textViewDisplay=findViewById<TextView>(R.id.textViewDisplay)
        var textViewErrorDisplay=findViewById<TextView>(R.id.textViewErrorDisplay)

        //Declaring buttons
        val btnPlus=findViewById<Button>(R.id.btnPlus)
        val btnMinus=findViewById<Button>(R.id.btnMinus)
        val btnMultiply=findViewById<Button>(R.id.btnMultiply)
        val btnDivide=findViewById<Button>(R.id.btnDivide)
        val btnPower=findViewById<Button>(R.id.btnPower)
        val btnSquareRoot=findViewById<Button>(R.id.btnSquareRoot)
        val btnStatisticFunctions=findViewById<Button>(R.id.btnStatisticFunctions)

        //Plus button
        btnPlus?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Plus button clicked", Toast.LENGTH_LONG).show()

            var number1=editTextNumberOne.text.toString().toInt()
            var number2=editTextNumberTwo.text.toString().toInt()

            var totalPlus: Number=0
            totalPlus=number1+number2

            textViewDisplay.text ="Addition:  ${editTextNumberOne.text} + ${editTextNumberTwo.text} = $totalPlus "
        }
        //Minus button
        btnMinus?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Minus button clicked", Toast.LENGTH_LONG).show()

            var number1=editTextNumberOne.text.toString().toInt()
            var number2=editTextNumberTwo.text.toString().toInt()

            var totalMinus: Number=0
            totalMinus=number1-number2

            textViewDisplay.text ="Subtraction:  ${editTextNumberOne.text} - ${editTextNumberTwo.text} = $totalMinus "
        }
        //Multiply button
        btnMultiply?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Multiply button clicked", Toast.LENGTH_LONG).show()

            var number1=editTextNumberOne.text.toString().toInt()
            var number2=editTextNumberTwo.text.toString().toInt()

            var totalMultiply: Number=0
            totalMultiply=number1*number2

            textViewDisplay.text ="Multiplication:  ${editTextNumberOne.text} * ${editTextNumberTwo.text} = $totalMultiply "
        }
        //Division button
        btnDivide?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Divide button clicked", Toast.LENGTH_LONG).show()

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
        //Power button
        btnPower?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Power button clicked", Toast.LENGTH_LONG).show()

            var number1=editTextNumberOne.text.toString().toInt()
            var number2=editTextNumberTwo.text.toString().toInt()

            var totalPower: Number=0
            totalPower= number1.toDouble().pow(number2.toDouble())

            textViewDisplay.text ="Power: ${editTextNumberOne.text} to the power of ${editTextNumberTwo.text}= $totalPower "
        }
        //Square root button
        btnSquareRoot?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Square root button clicked", Toast.LENGTH_LONG).show()

            var number1=editTextNumberOne.text.toString().toDouble()
            var totalSquareRoot: Number=0
            totalSquareRoot= sqrt(number1)

            textViewDisplay.text ="Square root: √${editTextNumberOne.text} = $totalSquareRoot "
        }
        //Statistic functions button
        btnStatisticFunctions?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Statistic functions button clicked", Toast.LENGTH_LONG).show()

            //Redirect to statistic functions page
            val intent= Intent(this,StatisticFunctions::class.java)

            startActivity(intent);
        }
    }
}