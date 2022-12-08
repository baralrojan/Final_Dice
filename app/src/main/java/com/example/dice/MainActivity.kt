package com.example.dice

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import java.lang.Math.random
import java.util.*
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var getSpinnerValue = ""

        var themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        themeSwitch.setOnCheckedChangeListener{ CompoundButton, onSwitch ->
            if(onSwitch){
                themeSwitch.setText("Dark")
                // on below line we are changing the theme to light mode.
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            else{
                themeSwitch.setText("Light")
                // on below line we are changing the theme to dark mode.
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

        }

        var viewRoll1 = findViewById<TextView>(R.id.viewRoll1)
        var viewRoll2 = findViewById<TextView>(R.id.viewRoll2)
        //Create array oof dice with different sides
        var dice = arrayOf("4","6", "8", "10","12","20")
        var diceSpinner = findViewById<Spinner>(R.id.diceSpinner)
        var arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, dice
        )
        diceSpinner.adapter = arrayAdapter

        //get selected spinner value and store in a variable
         diceSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    getSpinnerValue = dice[position]
                }
        }
        var randomValues1 = 0
        var randomValues2 = 0
        var btnRoll1 = findViewById<Button>(R.id.btnRoll1)
        //perform one roll when Roll1 is clicked
        btnRoll1.setOnClickListener {
            var number1 = getSpinnerValue.toInt()
            randomValues1 = Random.nextInt(number1) + 1
            viewRoll1.text = randomValues1.toString()
        }

        //perform two roll when Roll2 is clicked
        var btnRoll2 = findViewById<Button>(R.id.btnRoll2)
        btnRoll2.setOnClickListener {
            var number1 = getSpinnerValue.toInt()
            var randomValues1 = Random.nextInt(number1) + 1
            var randomValues2 = Random.nextInt(number1) + 1
            viewRoll1.text = randomValues1.toString()
            viewRoll2.text = randomValues2.toString()
        }



        }
}