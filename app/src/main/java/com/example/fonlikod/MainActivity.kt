package com.example.colorpicker

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mainLayout: View? = null
    private var colorPickerLayout: View? = null
    private var btnOpenColorPicker: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout. activity_main)

        mainLayout = findViewById<View>(R.id.main_lay)
        colorPickerLayout = findViewById<View>(R.id.color_picker_layout)
        btnOpenColorPicker = findViewById<Button>(R.id.btn_open_color_picker)

        val btnRed = findViewById<Button>(R.id.btn_red)
        val btnGreen = findViewById<Button>(R.id.btn_green)
        val btnBlue = findViewById<Button>(R.id.btn_blue)

        btnOpenColorPicker.setOnClickListener(View.OnClickListener { v: View? ->
            btnOpenColorPicker.setVisibility(View.GONE)
            colorPickerLayout.setVisibility(View.VISIBLE)
        })


        val colorClickListener = View.OnClickListener { view: View ->
            var selectedColor = "#FFFFFF" // Default rang
            when (view.id) {
                R.id.btn_red -> selectedColor = "#FF0000"
                R.id.btn_green -> selectedColor = "#00FF00"
                R.id.btn_blue -> selectedColor = "#0000FF"
            }

            mainLayout.setBackgroundColor(Color.parseColor(selectedColor))
            colorPickerLayout.setVisibility(View.GONE)
            btnOpenColorPicker.setVisibility(View.VISIBLE)
        }

        btnRed.setOnClickListener(colorClickListener)
        btnGreen.setOnClickListener(colorClickListener)
        btnBlue.setOnClickListener(colorClickListener)
    }
}