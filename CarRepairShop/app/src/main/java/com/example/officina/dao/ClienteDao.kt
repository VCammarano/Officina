package com.example.officina.dao

import androidx.room.*
import com.example.officina.entities.Cliente

// DAO per Cliente
@Dao
interface ClienteDao {
    @Query("SELECT * FROM clienti")
    fun getAllClienti(): List<Cliente>

    @Query("SELECT * FROM clienti WHERE id = :id")
    fun getClienteById(id: Int): Cliente?

    @Insert
    fun insertAllCliente(vararg clienti: Cliente)

    @Update
    fun updateCliente(cliente: Cliente)

    @Delete
    fun deleteCliente(cliente: Cliente)
}
