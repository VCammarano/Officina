package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.*

open class FiscalCodeCalculator {
    fun calculateCode(nome: String, cognome: String, dataNascita: String, sesso: String, luogoNascita: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val dataNascita = formatter.parse(dataNascita)
        val calendar = Calendar.getInstance()
        calendar.time = dataNascita
        val anno = calendar.get(Calendar.YEAR) % 100
        val mese = calendar.get(Calendar.MONTH) + 1
        val giorno = calendar.get(Calendar.DAY_OF_MONTH)
        val codiceFiscale= "$cognome${nome.substring(0, 1)}$anno${String.format("%02d", mese)}${String.format("%02d", giorno)}${sesso.substring(0, 1)}$luogoNascita"
        return codiceFiscale
    }

    fun calculate(nome: String, cognome: String, dataNascita: String, sesso: String, luogoNascita: String) {

    }
}
