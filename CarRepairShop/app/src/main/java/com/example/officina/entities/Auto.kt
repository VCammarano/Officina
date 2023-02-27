package com.example.officina.entities

import androidx.room.*

// Entity Auto
@Entity(
    tableName = "auto",
    foreignKeys = [
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["id"],
            childColumns = ["cliente_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["cliente_id"])
    ]
)
data class Auto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val numeroTelaio: String,
    val marca: String,
    val modello: String,
    val targa: String,
    @ColumnInfo(name = "cliente_id") val clienteId: Int
)