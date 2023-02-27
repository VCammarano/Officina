package com.example.mycalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result: Double = 0.0

        // Inizializzazione dei bottoni
        val zeroButton: Button = findViewById(R.id.zero)
        val oneButton: Button = findViewById(R.id.one)
        val twoButton: Button = findViewById(R.id.two)
        val threeButton: Button = findViewById(R.id.three)
        val fourButton: Button = findViewById(R.id.four)
        val fiveButton: Button = findViewById(R.id.five)
        val sixButton: Button = findViewById(R.id.six)
        val sevenButton: Button = findViewById(R.id.seven)
        val eightButton: Button = findViewById(R.id.eight)
        val nineButton: Button = findViewById(R.id.nine)
        val dotButton: Button = findViewById(R.id.dot)
        val addButton: Button = findViewById(R.id.add)
        val subtractButton: Button = findViewById(R.id.subtract)
        val multiplyButton: Button = findViewById(R.id.multiply)
        val divideButton: Button = findViewById(R.id.divide)
        val equalsButton: Button = findViewById(R.id.equals)
        val clearButton: Button = findViewById(R.id.clear)
        val backspaceButton: Button = findViewById(R.id.backspace)
        var resultEditText = findViewById<EditText>(R.id.result)

        // Impostazione degli ascoltatori per i bottoni
        zeroButton.setOnClickListener { appendNumber("0") }
        oneButton.setOnClickListener { appendNumber("1") }
        twoButton.setOnClickListener { appendNumber("2") }
        threeButton.setOnClickListener { appendNumber("3") }
        fourButton.setOnClickListener { appendNumber("4") }
        fiveButton.setOnClickListener { appendNumber("5") }
        sixButton.setOnClickListener { appendNumber("6") }
        sevenButton.setOnClickListener { appendNumber("7") }
        eightButton.setOnClickListener { appendNumber("8") }
        nineButton.setOnClickListener { appendNumber("9") }
        dotButton.setOnClickListener { appendDecimal() }
        addButton.setOnClickListener { appendOperator("+") }
        subtractButton.setOnClickListener { appendOperator("-") }
        multiplyButton.setOnClickListener { appendOperator("*") }
        divideButton.setOnClickListener { appendOperator("/") }
        equalsButton.setOnClickListener { calculate() }
        clearButton.setOnClickListener { clear() }
        backspaceButton.setOnClickListener { backspace() }
    }

    private fun appendNumber(number: String) {
        // Aggiunge il numero premuto all'EditText
        resultEditText.append(number)
    }

    private fun appendDecimal() {
        // Aggiunge il punto decimale all'EditText
        if (resultEditText.text.isEmpty()) {
            resultEditText.append("0.")
        } else if (!resultEditText.text.contains(".")) {
            resultEditText.append(".")
        }
    }

    private fun appendOperator(operator: String) {
        // Aggiunge l'operatore premuto all'EditText
        if (resultEditText.text.isNotEmpty()) {
            val lastChar = resultEditText.text.last()
            if (lastChar.isDigit()) {
                resultEditText.append(operator)
            } else if (lastChar == '.') {
                resultEditText.append("0$operator")
            }
        }
    }

    private fun calculate() {
        // Calcola il risultato dell'operazione inserita nell'EditText
        try {
            val expression = ExpressionBuilder(resultEditText.text.toString()).build()
            val result = expression.evaluate()
            resultEditText.setText(result.toString())
        } catch (e: Exception) {
            resultEditText.setText("Error")
        }
    }

    private fun clear() {
        // Pulisce l'EditText
        resultEditText.text.clear()
    }

    private fun backspace() {
        // Cancella l'ultimo carattere inserito dall'EditText
        val currentText = resultEditText.text.toString()
        if (currentText.isNotEmpty()) {
            resultEditText.setText(currentText.substring(0, currentText.length - 1))
        }
    }
}