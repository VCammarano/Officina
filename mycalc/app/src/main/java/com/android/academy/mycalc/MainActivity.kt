package com.android.academy.mycalc

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcService: CalcService = CalcServiceImpl()

        val digits = arrayOf(
            R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
            R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9
        )
        val operations = arrayOf(
            R.id.button_div, R.id.button_equals, R.id.button_minus,
            R.id.button_plus, R.id.button_times
        )

        val display = findViewById<TextView>(R.id.display).apply {
            text = calcService.display
        }

        for (b in digits) {
            findViewById<Button>(b).setOnClickListener {
                calcService.digit((it as Button).text[0])
                display.text = calcService.display
            }
        }
        for (b in operations) {
            findViewById<Button>(b).setOnClickListener {
                calcService.execute((it as Button).text[0])
                display.text = calcService.display
            }
        }

        findViewById<Button>(R.id.button_comma).setOnClickListener {
            calcService.comma()
            display.text = calcService.display
        }
        findViewById<Button>(R.id.button_change_sign).setOnClickListener {
            calcService.changeSign()
            display.text = calcService.display
        }
        findViewById<Button>(R.id.button_clear).setOnClickListener {
            calcService.clear()
            display.text = calcService.display
        }
        findViewById<Button>(R.id.button_clear_error).setOnClickListener {
            calcService.clearError()
            display.text = calcService.display
        }
    }
}