package com.example.officina.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clienti")
data class Cliente(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nome: String,
    val cognome: String,
    val telefono: String
)