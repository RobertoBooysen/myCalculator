package com.example.mycalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class StatisticFunctions : AppCompatActivity() {
    //Initializing an ArrayList of Integers called arrayListOfNumbers with 10 elements, all initialized to 0(Techie Delight, 2017).
    var arrayListOfNumbers = arrayListOf<Int>(0,0,0,0,0,0,0,0,0,0)

    //Declaring variable and initializing it with the value 0.
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic_function)

        //Declaring variables(The IIE,2023)
        var editTextStatisticNumber = findViewById<EditText>(R.id.editTextStatisticNumber)
        var textViewDisplayStoredNumbers = findViewById<TextView>(R.id.textViewDisplayStoredNumbers)
        var textViewDisplayAnswer = findViewById<TextView>(R.id.textViewDisplayAnswer)
        var textViewDisplayError = findViewById<TextView>(R.id.textViewDisplayError)

        //Declaring buttons(The IIE,2023)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnCalculateAverage = findViewById<Button>(R.id.btnCalculateAverage)
        val btnFindMinAndMax = findViewById<Button>(R.id.btnFindMinAndMax)

        //Add button(The IIE,2023)
        btnAdd?.setOnClickListener {
            Toast.makeText(this@StatisticFunctions, "Add button clicked", Toast.LENGTH_LONG).show()

            arrayListOfNumbers[counter] = editTextStatisticNumber.text.toString().toInt()// The code adds a number to the arrayListOfNumbers array. The number is obtained from the EditText called editTextStatisticNumber, which is converted to an integer using the toInt() method.
            counter++ // The position in the array where the number is added is determined by a counter variable called counter, which is incremented after each number is added.
            textViewDisplayStoredNumbers.text = arrayListOfNumbers.joinToString(" ")//The joinToString() method is used to convert the array to a string with each element separated by a space.
            editTextStatisticNumber.setText("")
            if (counter == 10) {//If statement for when the user enters the 10th number to display that there can only be 10 numbers entered.
                textViewDisplayError.text = "More than 10 numbers can't be entered!"//Output message
                textViewDisplayError.setTextColor(Color.parseColor("red"))//Displaying error message in red so users can know not to enter more then two numbers
            }
        }
        //Clear button(The IIE,2023)
        btnClear?.setOnClickListener {
            Toast.makeText(this@StatisticFunctions, "Clear button clicked", Toast.LENGTH_LONG).show()

            //Resetting text views
            textViewDisplayStoredNumbers.text=""
            textViewDisplayError.text = ""
            textViewDisplayAnswer.text = ""
            //Resetting array list
            arrayListOfNumbers=arrayListOf<Int>(0,0,0,0,0,0,0,0,0,0)
            //Resetting counter variable
            counter = 0
        }
        //Calculate Average button(The IIE,2023)
        btnCalculateAverage?.setOnClickListener {
            Toast.makeText(this@StatisticFunctions, "Calculate Average button clicked", Toast.LENGTH_LONG).show()

            val avg = arrayListOfNumbers.average()//The average of the ArrayList of numbers is calculated using the average() function(Techie Delight, 2017).
            textViewDisplayAnswer.text = "Average = ${avg}" //Displaying average
        }
        //Find Min and Max button(The IIE,2023)
        btnFindMinAndMax?.setOnClickListener {
            Toast.makeText(this@StatisticFunctions, "Find Min And Max button clicked", Toast.LENGTH_LONG).show()

            var max = arrayListOfNumbers.indices.maxOfOrNull { i: Int -> arrayListOfNumbers[i] } //The maxOfOrNull() method is used to find the maximum value in the array list.The indices property is used to get the indices of the array list(Techie Delight, 2016).
            var min = arrayListOfNumbers.indices.minOfOrNull { i: Int -> arrayListOfNumbers[i] } //The minOfOrNull() method is used to find the minimum value in the array list.The indices property is used to get the indices of the array list(Techie Delight, 2016).
            textViewDisplayAnswer.text = ("MAX= ${max} MIN= ${min}") //Displaying maximum and minimum values

        }
    }
}