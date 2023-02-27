package com.example.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Trova i riferimenti ai vari elementi della UI
        val inputNome = findViewById<EditText>(R.id.inputNome)
        val inputCognome = findViewById<EditText>(R.id.inputCognome)
        val inputDataNascita = findViewById<EditText>(R.id.inputDataNascita)
        val radioMaschio = findViewById<RadioButton>(R.id.radioMaschio)
        val inputLuogoNascita = findViewById<EditText>(R.id.inputLuogoNascita)
        val pulsanteCalcola = findViewById<Button>(R.id.pulsanteCalcola)
        val labelRisultato = findViewById<TextView>(R.id.labelRisultato)

        // Associare un OnClickListener al pulsante
        pulsanteCalcola.setOnClickListener {
            // Recupera i valori degli input dall'utente
            val nome = inputNome.text.toString()
            val cognome = inputCognome.text.toString()
            val dataNascita = inputDataNascita.text.toString()
            val sesso = if (radioMaschio.isChecked) "Maschio" else "Femmina"
            val luogoNascita = inputLuogoNascita.text.toString()
            val data = PersonalData(nome, cognome, dataNascita, sesso, luogoNascita)

            // Chiamare la funzione di calcolo del codice fiscale
            labelRisultato.text = calculate(nome, cognome, dataNascita, sesso, luogoNascita).toString()
        }
    }

    private fun PersonalData(nome: String, cognome: String, dataNascita: String) {

    }

    private fun calculate(nome: String, cognome: String, dataNascita: String, sesso: String, luogoNascita: String) {

    }
}
fun main() {
    val calculator = FiscalCodeCalculator()
    val nome = "Mario"
    val cognome = "Rossi"
    val dataNascita = "1980-01-15"
    val sesso = "Maschio"
    val luogoNascita = "RM"
    println(calculator.calculate(nome, cognome, dataNascita, sesso, luogoNascita))
}