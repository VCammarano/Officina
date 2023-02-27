package com.example.myapplication

enum class Sesso { Male, Female}

data class PersonalData(
    val nome: String,
    val cognome: String,
    val dataNascita: String,
    val sesso: String,
    val comuneNascita: String,
)