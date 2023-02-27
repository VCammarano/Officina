package com.example.officina.dao

import androidx.room.*
import com.example.officina.entities.Auto

// DAO per Auto
@Dao
interface AutoDao {
    @Query("SELECT * FROM auto")
    fun getAllAuto(): List<Auto>

    @Query("SELECT * FROM auto WHERE cliente_id = :clienteId")
    fun getAutoByCliente(clienteId: Int): List<Auto>

    @Query("SELECT * FROM auto WHERE id = :id")
    fun getAutoById(id: Int): Auto?

    @Insert
    fun insertAllAuto(vararg autos: Auto)

    @Update
    fun updateAuto(auto: Auto)

    @Delete
    fun deleteAuto(auto: Auto)
}
