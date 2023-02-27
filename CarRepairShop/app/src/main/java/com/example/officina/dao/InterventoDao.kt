package com.example.officina.dao

import androidx.room.*
import com.example.officina.entities.Intervento

// DAO per Intervento
@Dao
interface InterventoDao {
    @Query("SELECT * FROM interventi")
    fun getAllInterventi(): List<Intervento>

    @Query("SELECT * FROM interventi WHERE id = :id")
    fun getIntervento(id: Int): Intervento?

    @Query("SELECT * FROM interventi WHERE auto_id = :autoId")
    fun getInterventiByAuto(autoId: Int): List<Intervento>

    @Insert
    fun insertAllInterventi(vararg interventi: Intervento)

    @Update
    fun updateIntervento(intervento: Intervento)

    @Delete
    fun deleteIntervento(intervento: Intervento)
}
