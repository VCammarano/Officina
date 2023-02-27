package com.example.officina.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// Entity Intervento
@Entity(
    tableName = "interventi",
    foreignKeys = [
        ForeignKey(
            entity = Auto::class,
            parentColumns = ["id"],
            childColumns = ["auto_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["auto_id"])
    ]
)
data class Intervento(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val descrizione: String,
    val durata: Int,
    val dataArrivo: Long,
    val dataConsegna: Long,
    val auto_id: Int
)