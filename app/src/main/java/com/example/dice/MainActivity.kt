package com.example.dice

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        }
}